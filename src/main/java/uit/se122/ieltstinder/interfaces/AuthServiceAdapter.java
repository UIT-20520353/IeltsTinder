package uit.se122.ieltstinder.interfaces;

import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.service.dto.request.AuthLoginRequestDto;
import uit.se122.ieltstinder.service.dto.request.AuthRegisterRequestDto;
import uit.se122.ieltstinder.service.dto.response.AuthLoginResponseDto;

public interface AuthServiceAdapter {

    AuthLoginResponseDto login(AuthLoginRequestDto body, Role role);
    void register(AuthRegisterRequestDto body);
    void logout();

}
