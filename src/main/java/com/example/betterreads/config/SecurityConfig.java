package com.example.betterreads.config;


import com.example.betterreads.repositories.UserRepository;
import com.example.betterreads.service.impl.BetterReadsUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BetterReadsUserDetailsService userDetailsService(UserRepository userRepository) {
        return new BetterReadsUserDetailsService(userRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequests ->
                                authorizeRequests
//                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .requestMatchers("/", "/login", "/register", "/error").permitAll()
                                        .anyRequest()
                                        .authenticated()
                )
                .formLogin(formLogin ->
                        formLogin

                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/home", true)
                                .failureForwardUrl("/users/login-error")
                )

                .logout(
                        logout ->
                                logout
                                        .logoutUrl("users/logout")
                                        .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true)
                )
                .build();
    }
}
