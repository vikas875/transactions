package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.ServiceChargeDetailsID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.ServiceChargeDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceChargeDetailsRepository extends JpaRepository<ServiceChargeDetails, ServiceChargeDetailsID> {
}
