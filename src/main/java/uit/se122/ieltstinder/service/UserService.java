package uit.se122.ieltstinder.service;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.service.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto createUser(User user);
    UserDto findUserById(Long id);
    void deleteUser(Long id);
}
