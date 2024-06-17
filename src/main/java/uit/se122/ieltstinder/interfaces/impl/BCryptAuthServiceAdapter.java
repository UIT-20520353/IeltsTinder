package uit.se122.ieltstinder.interfaces.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.interfaces.AuthServiceAdapter;
import uit.se122.ieltstinder.interfaces.PasswordEncoderCallback;
import uit.se122.ieltstinder.service.AuthService;
import uit.se122.ieltstinder.service.dto.request.AuthLoginRequestDto;
import uit.se122.ieltstinder.service.dto.request.AuthRegisterRequestDto;
import uit.se122.ieltstinder.service.dto.response.AuthLoginResponseDto;

@Component
@AllArgsConstructor
public class BCryptAuthServiceAdapter implements AuthServiceAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Override
    public AuthLoginResponseDto login(AuthLoginRequestDto body, Role role) {
        return authService.login(body, role, new PasswordEncoderCallback() {
            @Override
            public boolean matches(String password, String encodedPassword) {
                return passwordEncoder.matches(password, encodedPassword);
            }
        });
    }

    @Override
    public void register(AuthRegisterRequestDto body) {
        body.setPassword(passwordEncoder.encode(body.getPassword()));
        authService.register(body);
    }

    @Override
    public void logout() {
        authService.logout();
    }

}
