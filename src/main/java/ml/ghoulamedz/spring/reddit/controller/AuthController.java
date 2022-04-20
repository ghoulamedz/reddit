package ml.ghoulamedz.spring.reddit.controller;

import lombok.RequiredArgsConstructor;
import ml.ghoulamedz.spring.reddit.security.RegisterRequest;
import ml.ghoulamedz.spring.reddit.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<String> signup(RegisterRequest registerRequest){
        authService.registerUser(registerRequest);
        return ResponseEntity.ok("registered user successfully");
    }
    @GetMapping("/verifyAccount/{token}")
    public ResponseEntity<String> activateAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return ResponseEntity.ok("Account activated successfully");
    }

}
