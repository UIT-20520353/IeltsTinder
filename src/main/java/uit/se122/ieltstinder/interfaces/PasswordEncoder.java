package uit.se122.ieltstinder.interfaces;

public interface PasswordEncoder {

    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);

}
