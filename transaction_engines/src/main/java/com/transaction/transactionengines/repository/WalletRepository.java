package com.transaction.transactionengines.repository;


import com.transaction.transactionengines.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,String> {

    Optional<Wallet> findByUserId(String s);
}
