package uit.se122.ieltstinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.entity.enumeration.TestLevel;
import uit.se122.ieltstinder.entity.enumeration.UserStatus;

import java.util.List;

@Entity
@Table(name = "t_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "description")
    private String description;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    Role role;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    UserStatus status;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserSession> sessions;

    @Column(name = "video_sdk_token")
    private String videoSdkToken;

    @Column(name = "is_first_login")
    private Boolean isFirstLogin;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private TestLevel level;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts;

    public void setNewSession(UserSession session) {
        session.setUser(this);
        this.sessions.clear();
        this.sessions.add(session);
    }

    public static class UserBuilder {

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

        public User build() {
            return new User(this.id, this.firstName, this.lastName, this.email, this.password, this.address, this.gender, this.age, this.description, this.avatar, this.role, this.status, null, this.videoSdkToken, this.isFirstLogin, this.level, null);
        }


    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

}
