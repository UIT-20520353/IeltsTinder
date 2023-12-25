package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uit.se122.ieltstinder.entity.Friend;
import uit.se122.ieltstinder.entity.Request;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.repository.FriendRepository;
import uit.se122.ieltstinder.repository.RequestRepository;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.service.RequestService;
import uit.se122.ieltstinder.service.dto.RequestDto;
import uit.se122.ieltstinder.service.mapper.RequestMapper;

import static uit.se122.ieltstinder.constant.MessageConstant.REQUEST_NOT_EXIST;
import static uit.se122.ieltstinder.constant.MessageConstant.USER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final FriendRepository friendRepository;
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final RequestMapper requestMapper;

    @Override
    @Transactional
    public void createRequest(Long userId, Long targetUserId) {
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));
        User targetUser = userRepository.findById(targetUserId)
                        .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        requestRepository.save(Request
                .builder()
                .sender(user)
                .receiver(targetUser)
                .build()
        );
    }

    @Override
    public Page<RequestDto> getRequests(Long userId, Pageable pageable) {
        return requestRepository.findByUserId(userId, pageable).map(requestMapper::toRequestDto);
    }

    @Override
    public void deleteRequest(Long requestId) {
        requestRepository.deleteById(requestId);
    }

    @Override
    public void acceptRequest(Long requestId) {
        Request request = requestRepository.findById(requestId)
                        .orElseThrow(() -> new BadRequestException(REQUEST_NOT_EXIST));
        User user = userRepository.findById(request.getSender().getId())
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));
        User targetUser = userRepository.findById(request.getReceiver().getId())
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        friendRepository.save(Friend
                .builder()
                .user(user)
                .friend(targetUser)
                .build()
        );

        requestRepository.deleteById(requestId);
    }

    @Override
    public void deleteRequestByUserId(Long sender, Long receiver) {
        requestRepository.deleteBySenderAndReceiver(sender, receiver);
    }

}
