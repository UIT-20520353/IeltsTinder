package uit.se122.ieltstinder.interfaces;

public interface PasswordEncoderCallback {
    boolean matches(String password, String encodedPassword);
}
