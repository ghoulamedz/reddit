package ml.ghoulamedz.spring.reddit.security;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        if (checkForRole(authentication, "ROLE_ADMIN")) {
            redirectToSuccessUrl(request, response, "/api/auth/db");
        } else {
            redirectToSuccessUrl(request, response, "/dashboard");
            log.info("Login success, Redirecting to dashboard");
        }
    }

    private void redirectToSuccessUrl(HttpServletRequest request, HttpServletResponse response, String success_url)
            throws IOException {
        RedirectStrategy redirectStrategy = super.getRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, success_url);
    }

    public boolean checkForRole(Authentication authentication, String role) {
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()).contains(role);
        }
        return false;
    }
}
