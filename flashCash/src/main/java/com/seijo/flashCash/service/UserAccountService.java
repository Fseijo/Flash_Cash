package com.seijo.flashCash.service;

import com.seijo.flashCash.model.UserAccount;
import com.seijo.flashCash.repositories.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccount> findAll(){
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> findById(Integer id){
        return userAccountRepository.findById(id);
    }

    public UserAccount findByIban(String iban){
        return userAccountRepository.findByIban(iban);
    }
}
