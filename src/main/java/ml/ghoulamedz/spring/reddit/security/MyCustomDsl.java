package ml.ghoulamedz.spring.reddit.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {

    @Override
    public void init(HttpSecurity http) throws Exception {
        // any method that adds another configurer
        // must be done in the init method
        http.csrf(csrf -> csrf.disable());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        final AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        CustomAuthFilter customAuthFilter = new CustomAuthFilter(authenticationManager);
        customAuthFilter.setFilterProcessesUrl("/api/auth/login");
        http.antMatcher("/api/auth/login").addFilter(customAuthFilter);
        log.info("added the custom auth filter");

    }

    public static MyCustomDsl customDsl() {
        return new MyCustomDsl();
    }
}