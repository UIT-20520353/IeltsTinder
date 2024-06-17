package uit.se122.ieltstinder.interfaces.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uit.se122.ieltstinder.interfaces.PasswordEncoder;

public class BCryptPasswordEncoderAdapter implements PasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public  BCryptPasswordEncoderAdapter() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }

}
