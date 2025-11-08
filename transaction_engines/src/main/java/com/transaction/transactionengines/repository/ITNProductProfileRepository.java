package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.ITNProductProfile;
import com.transaction.transactionengines.entity.ProductID;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITNProductProfileRepository extends JpaRepository<ITNProductProfile, ProductID> {
    Optional<ITNProductProfile> findByProductIdValue(String productID);
    Optional<ITNProductProfile> findByProductIdValueAndStatus(String productId, String status);
}
