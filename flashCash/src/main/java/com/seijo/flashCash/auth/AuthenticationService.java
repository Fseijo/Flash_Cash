package com.seijo.flashCash.auth;


import com.seijo.flashCash.model.Role;
import com.seijo.flashCash.model.User;
import com.seijo.flashCash.model.UserAccount;
import com.seijo.flashCash.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    public User register(RegisterRequest request) {
        UserAccount account = new UserAccount();
        account.setAmount(0.0);
        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .account(account)
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
       return userRepository.save(user);
    }

//    public UserDetails authenticateUser(AuthenticationRequest request){
//
//    }

}
