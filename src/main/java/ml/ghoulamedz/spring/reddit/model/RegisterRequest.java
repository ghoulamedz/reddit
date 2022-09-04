package ml.ghoulamedz.spring.reddit.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {
    @NotBlank(message = "Username cannot be empty!")
    private String username;
    @NotBlank(message = "Password cannot be empty!")
    private String password;
    @Email
    @NotBlank(message = "Email cannot be empty!")
    private String email;
}
