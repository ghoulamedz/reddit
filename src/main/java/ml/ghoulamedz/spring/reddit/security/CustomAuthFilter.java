package ml.ghoulamedz.spring.reddit.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager auth;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        log.info("Attempting authentication ...");
        return auth.authenticate(
                new UsernamePasswordAuthenticationToken(req.getParameter("username"), req.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(req, res, chain, authResult);
        String current_security_context_principal = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();
        String auth_result_principal = authResult.getPrincipal().toString();
        log.info("successful auth !!");
        log.info("logged in as: " + current_security_context_principal + "from SecurityContext");
        log.info("logged in as: " + auth_result_principal + "from authResult (my custom filter)");
        res.addHeader("X-securityContext-principal", "logged in as: " + current_security_context_principal);
        res.addHeader("X-authResult-principal", "logged in as: " + auth_result_principal);
    }
}
