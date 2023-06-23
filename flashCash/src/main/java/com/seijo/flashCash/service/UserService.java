package com.seijo.flashCash.service;

import com.seijo.flashCash.model.User;
import com.seijo.flashCash.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> finAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
