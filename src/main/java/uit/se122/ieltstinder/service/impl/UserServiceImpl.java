package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.mapper.UserMapper;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.service.UserService;
import uit.se122.ieltstinder.service.dto.UserDto;

import java.util.List;

import static uit.se122.ieltstinder.constant.MessageConstant.USER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        return userMapper.toUserDto(user);
    }

}
