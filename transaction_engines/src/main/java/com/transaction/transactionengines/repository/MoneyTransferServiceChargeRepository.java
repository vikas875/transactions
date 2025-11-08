package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.MoneyTransferServiceCharge;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransferServiceChargeRepository extends JpaRepository<MoneyTransferServiceCharge, String>  {
}
