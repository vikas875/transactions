package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.MoneyTransferServiceChargeDetails;
import com.transaction.transactionengines.entity.ServiceChargeDetailsID;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransferServiceChargeDetailsRepository extends JpaRepository<MoneyTransferServiceChargeDetails,ServiceChargeDetailsID> {

}
