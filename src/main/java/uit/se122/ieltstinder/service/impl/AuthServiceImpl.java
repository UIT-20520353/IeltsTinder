package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.entity.UserSession;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.entity.enumeration.UserStatus;
import uit.se122.ieltstinder.exception.AuthenticationException;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.security.SecurityUtils;
import uit.se122.ieltstinder.security.jwt.GenerateJwtResult;
import uit.se122.ieltstinder.security.jwt.JwtProvider;
import uit.se122.ieltstinder.service.AuthService;
import uit.se122.ieltstinder.service.UserSessionService;
import uit.se122.ieltstinder.service.dto.request.AuthLoginRequestDto;
import uit.se122.ieltstinder.service.dto.request.AuthRegisterRequestDto;
import uit.se122.ieltstinder.service.dto.response.AuthLoginResponseDto;

import java.util.Objects;

import static uit.se122.ieltstinder.constant.MessageConstant.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserSessionService userSessionService;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public AuthLoginResponseDto login(AuthLoginRequestDto request) {
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthenticationException(INVALID_CREDENTIAL_ERR));

        if (UserStatus.BLOCKED.equals(user.getStatus())) {
            throw new AuthenticationException(USER_WAS_BLOCKED_ERR);
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new AuthenticationException(INVALID_CREDENTIAL_ERR);
        }

        GenerateJwtResult jwtTokens = jwtProvider.generateToken(user);
        user.setNewSession(new UserSession(jwtTokens.tokenId(), jwtTokens.expiredDate()));
        return new AuthLoginResponseDto(jwtTokens.accessToken(), jwtTokens.refreshToken());
    }

    @Override
    @Transactional
    public void logout() {
        String tokenId = SecurityUtils.getCurrentTokenId();
        userSessionService.removeExpiredSession(tokenId);
    }

    @Override
    @Transactional
    public void register(AuthRegisterRequestDto request) {
        userRepository
                .findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new BadRequestException(USER_ALREADY_EXIST_ERR);
                });

        userRepository.save(User
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .age(request.getAge())
                .gender(request.getGender())
                .address(request.getAddress())
                .overall(0.0)
                .target(0.0)
                .description("")
                .avatar(null)
                .role(Role.USER)
                .status(UserStatus.ACTIVE)
                .build()
        );
    }

}
