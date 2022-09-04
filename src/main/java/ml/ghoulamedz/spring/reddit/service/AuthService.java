package ml.ghoulamedz.spring.reddit.service;

import lombok.RequiredArgsConstructor;
import ml.ghoulamedz.spring.reddit.exception.RedditException;
import ml.ghoulamedz.spring.reddit.model.LoginReq;
import ml.ghoulamedz.spring.reddit.model.NotificationEmail;
import ml.ghoulamedz.spring.reddit.model.RegisterRequest;
import ml.ghoulamedz.spring.reddit.model.User;
import ml.ghoulamedz.spring.reddit.model.VerificationToken;
import ml.ghoulamedz.spring.reddit.repository.UserRepository;
import ml.ghoulamedz.spring.reddit.repository.VerificationTokenRepository;
import ml.ghoulamedz.spring.reddit.security.CustomAuthFilter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import java.util.List;
import static ml.ghoulamedz.spring.reddit.util.Constants.ACTIVATION_EMAIL;
import static java.time.Instant.now;

@Transactional
@RequiredArgsConstructor
@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    // private final MailService mailService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public void registerUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        user.setCreatedDate(now());
        user.setActivated(true);
        userRepository.save(user);
        // String token = generateVerificationToken(user);
        // String message = "Thank you for signing up to ghoulamedz Reddit, please click
        // on the below url to activate your account : "
        // + ACTIVATION_EMAIL + "/" + token;
        // mailService.sendMail(new NotificationEmail("Please Activate your account",
        // user.getEmail(), message));
    }

    @Transactional
    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationTokenOptional = verificationTokenRepository.findByToken(token);
        verificationTokenOptional.orElseThrow(() -> new RedditException("Invalid Token"));
        fetchUserAndEnable(verificationTokenOptional.get());
    }

    @Transactional
    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RedditException("User Not Found with name : " + username));
        user.setActivated(true);
        userRepository.save(user);
    }

    public String logout() {
        return "Logged out :)";
    }

}
