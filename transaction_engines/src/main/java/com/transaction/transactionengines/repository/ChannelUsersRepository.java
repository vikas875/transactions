package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.ChannelUsers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChannelUsersRepository extends JpaRepository<ChannelUsers,String> {
    Optional<ChannelUsers> findByEmailId(String email);
    Optional<ChannelUsers> findByUserId(String userId);
    Optional<ChannelUsers> findByUserIdAndStatus(String userId,String status );
    @Query(value = "SELECT user_id FROM itn_channel_users ORDER BY modified_on  DESC LIMIT 1", nativeQuery = true)
    String findLastUserId();
}
