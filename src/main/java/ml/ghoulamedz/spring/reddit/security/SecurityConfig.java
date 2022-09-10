package ml.ghoulamedz.spring.reddit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private LoginSuccessHandler loginSuccessHandler;

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        @Order(1)
        public SecurityFilterChain myFilter(HttpSecurity http) throws Exception {
                http
                                .authorizeRequests(
                                                auth -> auth.antMatchers("/home", "/api/auth/login", "/api/auth/signup",
                                                                "/api/auth/verifyAccount/**").permitAll()
                                                                .antMatchers("/api/auth/db", "/api/auth/admin")
                                                                .hasAuthority("ROLE_ADMIN")
                                                                .anyRequest()
                                                                .authenticated())
                                // .addFilter(null)
                                .formLogin(form -> form.loginPage("/home").successHandler(loginSuccessHandler)
                                                .failureUrl("/home")
                                                .defaultSuccessUrl("/dashboard").successForwardUrl("/dashboard"))
                                .logout(logout -> logout.logoutUrl("/api/auth/logout")
                                                .clearAuthentication(true)
                                                .deleteCookies("JSESSIONID"))
                                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                                                .maximumSessions(1)
                                                .maxSessionsPreventsLogin(false))
                                .apply(MyCustomDsl.customDsl());
                return http.build();

        }
}
