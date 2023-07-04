package com.seijo.flashCash.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("js/**","/bootstrap.min.css","/index.css", "/images/**", "/signup", "/", "/signin")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(
                        (form) -> form
                                .loginPage("/signin")
                                .permitAll()
                                .usernameParameter("email")
                                .defaultSuccessUrl("/home", true)
                )
                .logout(
                        (logout) -> logout
                                .permitAll()
                );
        return http.build();
    }
}
