package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.TransactionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TransactionHeaderRepository extends JpaRepository<TransactionHeader,String> {
    @Query(value = "SELECT transfer_id FROM itn_transaction_header ORDER BY transfer_on  DESC LIMIT 1", nativeQuery = true)
    String findLastTransferId();

    @Query("SELECT COALESCE(SUM(t.requestedValue), 0) FROM TransactionHeader t " +
            "WHERE DATE(t.transferOn) = CURRENT_DATE " +
            "AND t.transferStatus = 'SUCCESS' " +
            "AND t.payerUserId = :payerUserId")
    long getDailyTotal( String payerUserId);

    @Query("SELECT COALESCE(SUM(t.requestedValue), 0) FROM TransactionHeader t " +
            "WHERE t.transferOn >= :startDate " +
            "AND t.transferStatus = 'SUCCESS' " +
            "AND t.payerUserId = :payerUserId")
    long getWeeklyTotal(String payerUserId, LocalDateTime startDate);

    @Query("SELECT COALESCE(SUM(t.requestedValue), 0) FROM TransactionHeader t " +
            "WHERE FUNCTION('MONTH', t.transferOn) = FUNCTION('MONTH', CURRENT_DATE) " +
            "AND FUNCTION('YEAR', t.transferOn) = FUNCTION('YEAR', CURRENT_DATE) " +
            "AND t.transferStatus = 'SUCCESS' " +
            "AND t.payerUserId = :payerUserId")
    long getMonthlyTotal(String payerUserId);


}
