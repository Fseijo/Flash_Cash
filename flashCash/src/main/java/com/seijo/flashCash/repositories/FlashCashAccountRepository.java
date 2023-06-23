package com.seijo.flashCash.repositories;

import com.seijo.flashCash.model.FlashCashAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCashAccountRepository extends JpaRepository<FlashCashAccount, Integer>, JpaSpecificationExecutor<FlashCashAccount> {
}
