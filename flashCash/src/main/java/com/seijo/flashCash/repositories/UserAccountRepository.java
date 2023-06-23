package com.seijo.flashCash.repositories;

import com.seijo.flashCash.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>, JpaSpecificationExecutor<UserAccount> {

    UserAccount findByIban(String iban);
}
