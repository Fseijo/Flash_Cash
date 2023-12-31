package com.seijo.flashCash.repositories;

import com.seijo.flashCash.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer>, JpaSpecificationExecutor<Transfer> {
}
