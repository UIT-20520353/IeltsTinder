package uit.se122.ieltstinder.service;

import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.interfaces.PasswordEncoderCallback;
import uit.se122.ieltstinder.service.dto.request.AuthLoginRequestDto;
import uit.se122.ieltstinder.service.dto.request.AuthRegisterRequestDto;
import uit.se122.ieltstinder.service.dto.response.AuthLoginResponseDto;

public interface AuthService {

    AuthLoginResponseDto login(AuthLoginRequestDto body, Role role, PasswordEncoderCallback callback);
    void logout();
    void register(AuthRegisterRequestDto request);

}
