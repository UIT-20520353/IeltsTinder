package uit.se122.ieltstinder.interfaces.impl;

import lombok.AllArgsConstructor;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.interfaces.AuthServiceAdapter;
import uit.se122.ieltstinder.interfaces.PasswordEncoderCallback;
import uit.se122.ieltstinder.service.AuthService;
import uit.se122.ieltstinder.service.dto.request.AuthLoginRequestDto;
import uit.se122.ieltstinder.service.dto.request.AuthRegisterRequestDto;
import uit.se122.ieltstinder.service.dto.response.AuthLoginResponseDto;

@AllArgsConstructor
@Component
public class Argon2AuthServiceAdapter implements AuthServiceAdapter {

    private final AuthService authService;

    @Override
    public AuthLoginResponseDto login(AuthLoginRequestDto body, Role role) {
        return authService.login(body, role, new PasswordEncoderCallback() {
            @Override
            public boolean matches(String password, String encodedPassword) {
                Argon2Parameters.
                return passwordEncoder.matches(password, encodedPassword);
            }
        });
    }

    @Override
    public void register(AuthRegisterRequestDto body) {
        body.setPassword(hashPassword(body.getPassword()));
        authService.register(body);
    }

    @Override
    public void logout() {
        authService.logout();
    }

    public String hashPassword(String password) {
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withSalt("somesalt".getBytes());

            builder.
        
        Argon2BytesGenerator gen = new Argon2BytesGenerator();
        gen.init(builder.build());

        byte[] result = new byte[32];
        gen.generateBytes(result, password.getBytes());

        return new String(result);
    }

}
