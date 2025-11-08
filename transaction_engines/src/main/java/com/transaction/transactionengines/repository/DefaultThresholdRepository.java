package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.DefaultThreshold;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultThresholdRepository extends JpaRepository<DefaultThreshold, String> {

}
