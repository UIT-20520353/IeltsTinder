package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import uit.se122.ieltstinder.entity.ChatRoom;
import uit.se122.ieltstinder.entity.Message;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.repository.ChatRoomRepository;
import uit.se122.ieltstinder.repository.MessageRepository;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.service.ChatService;
import uit.se122.ieltstinder.socket.dto.MessageRequest;
import uit.se122.ieltstinder.socket.dto.MessageResponse;
import uit.se122.ieltstinder.socket.enumeration.MessageType;

import java.time.Instant;
import java.util.Optional;

import static uit.se122.ieltstinder.constant.MessageConstant.CHAT_ROOM_NOT_EXIST;
import static uit.se122.ieltstinder.constant.MessageConstant.USER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public MessageResponse sendMessage(MessageRequest request) {
        MessageResponse messageResponse = new MessageResponse(
                request.getUserId(),
                request.getMessage(),
                Instant.now()
        );

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));
        ChatRoom chatRoom = chatRoomRepository.findById(Long.parseLong(request.getChatroomId()))
                        .orElseThrow(() -> new BadRequestException(CHAT_ROOM_NOT_EXIST));

        messageRepository.save(Message
                .builder()
                .user(user)
                .message(request.getMessage())
                .date(Instant.now())
                .chatRoom(chatRoom)
                .build()
        );

        simpMessagingTemplate.convertAndSendToUser(request.getChatroomId(), "private", messageResponse);
        return messageResponse;
    }

}
