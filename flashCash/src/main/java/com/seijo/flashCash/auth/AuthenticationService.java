package com.seijo.flashCash.auth;


import com.seijo.flashCash.model.Role;
import com.seijo.flashCash.model.User;
import com.seijo.flashCash.model.UserAccount;
import com.seijo.flashCash.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        UserAccount account = new UserAccount();
        account.setAmount(0.0);
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .account(account)
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return AuthenticationResponse.builder()
                .build();
    }
}
