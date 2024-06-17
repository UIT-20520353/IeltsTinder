package uit.se122.ieltstinder.entity.builder;

import uit.se122.ieltstinder.entity.Post;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.entity.enumeration.TestLevel;
import uit.se122.ieltstinder.entity.enumeration.UserStatus;

import java.util.List;

public class UserBuilder {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private Integer gender;
    private Integer age;
    private String description;
    private String avatar;
    private Role role;
    private UserStatus status;
    private String videoSdkToken;
    private Boolean isFirstLogin;
    private TestLevel level;
    private List<Post> posts;

    private UserBuilder() {}

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder id(final Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder email(final String email) {
        this.email = email;
        return this;
    }

    public UserBuilder password(final String password) {
        this.password = password;
        return this;
    }

    public UserBuilder address(final String address) {
        this.address = address;
        return this;
    }

    public UserBuilder gender(final Integer gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder age(final Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder description(final String description) {
        this.description = description;
        return this;
    }

    public UserBuilder avatar(final String avatar) {
        this.avatar = avatar;
        return this;
    }

    public UserBuilder role(final Role role) {
        this.role = role;
        return this;
    }

    public UserBuilder status(final UserStatus status) {
        this.status = status;
        return this;
    }

    public UserBuilder videoSdkToken(final String videoSdkToken) {
        this.videoSdkToken = videoSdkToken;
        return this;
    }

    public UserBuilder isFirstLogin(final Boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
        return this;
    }

    public UserBuilder level(final TestLevel level) {
        this.level = level;
        return this;
    }

    public UserBuilder posts(final List<Post> posts) {
        this.posts = posts;
        return this;
    }

    public User build() {
        return new User(this.id, this.firstName, this.lastName, this.email, this.password, this.address, this.gender, this.age, this.description, this.avatar, this.role, this.status, null, this.videoSdkToken, this.isFirstLogin, this.level, this.posts);
    }

}
