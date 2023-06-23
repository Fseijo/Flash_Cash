package com.seijo.flashCash.repositories;

import com.seijo.flashCash.model.LinkedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedAccountRepository extends JpaRepository<LinkedAccount, Integer>, JpaSpecificationExecutor<LinkedAccount> {
}
