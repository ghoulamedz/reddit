package ml.ghoulamedz.spring.reddit.service;

import lombok.AllArgsConstructor;
import ml.ghoulamedz.spring.reddit.dto.UserDto;
import ml.ghoulamedz.spring.reddit.model.User;
import ml.ghoulamedz.spring.reddit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setCreatedDate(Instant.now());
        user.setActivated(false);
        userRepository.save(user);
    }
}
