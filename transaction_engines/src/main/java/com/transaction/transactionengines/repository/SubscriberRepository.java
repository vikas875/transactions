package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.Subscribers;
import com.transaction.transactionengines.enums.SubscriberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscribers,String> {
    Optional<Subscribers> findBySubscriberId(String subscriberId);
    Optional<Subscribers> findBySubscriberIdAndStatus(String subscriberId, SubscriberStatus status);

    @Query(value = "SELECT thres_profile_id FROM itn_channel_users ORDER BY modified_on  DESC LIMIT 1", nativeQuery = true)
    String findLastSubscriberId();

}
