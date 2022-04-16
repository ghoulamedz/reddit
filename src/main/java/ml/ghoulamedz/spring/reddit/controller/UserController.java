package ml.ghoulamedz.spring.reddit.controller;

import lombok.AllArgsConstructor;
import ml.ghoulamedz.spring.reddit.dto.UserDto;
import ml.ghoulamedz.spring.reddit.model.User;
import ml.ghoulamedz.spring.reddit.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}
