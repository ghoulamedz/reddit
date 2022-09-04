package ml.ghoulamedz.spring.reddit.security;

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

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        @Order(1)
        public SecurityFilterChain myFilter(HttpSecurity http) throws Exception {
                http.authorizeRequests(
                                auth -> auth.antMatchers("/api/auth/db", "/api/auth/admin")
                                                .hasAuthority("ROLE_ADMIN")
                                                .antMatchers("/api/auth/signup",
                                                                "/api/auth/verifyAccount/**",
                                                                "/api/auth/login")
                                                .permitAll()
                                                .anyRequest()
                                                .authenticated())
                                // .addFilter(null)
                                // .formLogin(form -> form
                                // .usernameParameter("username")
                                // .passwordParameter("password")
                                // .loginPage("/api/auth/login").failureUrl("/api/auth/signup"))
                                // .logout(logout -> logout.logoutUrl("/api/auth/logout")
                                // .clearAuthentication(true)
                                // .deleteCookies("JSESSIONID"))
                                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                                .maximumSessions(1)
                                                .maxSessionsPreventsLogin(true))
                                .apply(MyCustomDsl.customDsl());
                return http.build();

        }
}
