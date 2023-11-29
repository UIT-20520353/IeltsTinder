package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.entity.User_;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.service.criteria.UserCriteria;
import uit.se122.ieltstinder.service.dto.response.UserProfileResponseDto;
import uit.se122.ieltstinder.service.mapper.UserMapper;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.service.UserService;
import uit.se122.ieltstinder.service.dto.UserDto;
import uit.se122.ieltstinder.service.query.QueryService;

import java.util.Objects;

import static uit.se122.ieltstinder.constant.MessageConstant.USER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends QueryService<User> implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public Page<UserDto> getAllUsers(UserCriteria criteria, Pageable pageable) {
        Specification<User> specification = createSpecification(criteria);
        return userRepository.findAll(specification, pageable).map(userMapper::toUserDto);
    }

    private Specification<User> createSpecification(UserCriteria criteria) {
        Specification<User> specification = Specification.where(null);
        if (criteria != null) {
            if (Objects.nonNull(criteria.getFirstName())) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), User_.firstName));
            }
        }

        return specification;
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
    public UserProfileResponseDto getUserProfile(Long userId) {
        User user = userRepository
                        .findById(userId)
                        .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        return userMapper.toUserProfile(user);
    }

}
