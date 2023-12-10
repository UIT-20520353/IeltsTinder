package uit.se122.ieltstinder.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.service.dto.UserDto;
import uit.se122.ieltstinder.service.dto.response.UserProfileResponseDto;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDto toUserDto(User user) {
        return new UserDto(
          user.getId(),
          user.getFirstName(),
          user.getLastName(),
          user.getAddress(),
          user.getGender() == 1 ? "Male" : "Female",
          user.getAge(),
          user.getOverall(),
          user.getTarget(),
          user.getDescription(),
          user.getAvatar(),
          user.getStatus(),
          user.getRole()
        );
    }

    public UserProfileResponseDto toUserProfile(User user) {
        return new UserProfileResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getGender() == 1 ? "Male" : "Female",
                user.getAge(),
                user.getOverall(),
                user.getTarget(),
                user.getDescription(),
                user.getAvatar()
        );
    }

}
