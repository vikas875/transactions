package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.SubscriberWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberWalletRepository extends JpaRepository<SubscriberWallet,String> {

    Optional<SubscriberWallet> findBySubscriberId(String subscriberId);
}
