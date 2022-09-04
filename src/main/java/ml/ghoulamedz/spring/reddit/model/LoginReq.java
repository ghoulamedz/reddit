package ml.ghoulamedz.spring.reddit.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginReq {
    @NotBlank(message = "Username cannot be empty!")
    private String username;
    @NotBlank(message = "Password cannot be empty!")
    private String password;
}
