package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.service.mapper.UserMapper;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserDto).toList();
    }

    @Override
    @Transactional
    public UserDto createUser(User user) {
        userRepository.save(User
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .address(user.getAddress())
                .age(user.getAge())
                .gender(user.getGender())
                .overall(0.0)
                .target(0.0)
                .description("")
                .avatar(null)
                .build()
        );
        return userMapper.toUserDto(user);
    }

    @Override
    @Transactional
    public UserDto findUserById(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        return userMapper.toUserDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
