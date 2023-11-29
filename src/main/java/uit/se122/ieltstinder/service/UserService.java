package uit.se122.ieltstinder.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uit.se122.ieltstinder.service.criteria.UserCriteria;
import uit.se122.ieltstinder.service.dto.UserDto;
import uit.se122.ieltstinder.service.dto.response.UserProfileResponseDto;

public interface UserService {
    Page<UserDto> getAllUsers(UserCriteria criteria, Pageable pageable);
    UserDto findUserById(Long id);
    UserProfileResponseDto getUserProfile(Long userId);
}
