package ml.ghoulamedz.spring.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
}
