package com.seijo.flashCash.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**", "static/bootstrap.min.css", "static/index.css", "images/**", "static/bootstrap.bundle.min.js")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(
                        (form)-> form
                                .loginPage("/signin")
                                .permitAll()
                                .usernameParameter("email")
                                .defaultSuccessUrl("/", true)
                )
                .logout(
                        (logout)-> logout
                                .permitAll()
                );
//                .sessionManagement(
//                        (session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
