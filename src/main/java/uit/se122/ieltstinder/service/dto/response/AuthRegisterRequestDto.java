package uit.se122.ieltstinder.service.dto.response;

import lombok.Data;

@Data
public class AuthRegisterRequestDto {

    private String name;
    private String email;
    private String password;
    private String address;
    private String gender;
    private Integer age;

}
