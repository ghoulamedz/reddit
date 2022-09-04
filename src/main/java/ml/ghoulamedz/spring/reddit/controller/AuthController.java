package ml.ghoulamedz.spring.reddit.controller;

import lombok.RequiredArgsConstructor;
import ml.ghoulamedz.spring.reddit.model.LoginReq;
import ml.ghoulamedz.spring.reddit.model.RegisterRequest;
import ml.ghoulamedz.spring.reddit.service.AuthService;

import javax.validation.ReportAsSingleViolation;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/db")
    public String getdb() {
        return authService.getAllUsers().toString();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.ok("registered user successfully");
    }

    @GetMapping("/verifyAccount/{token}")
    public ResponseEntity<String> activateAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return ResponseEntity.ok("Account activated successfully");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        authService.logout();
        return ResponseEntity.ok("Logged out successfuly");
    }

}
