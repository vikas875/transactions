package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.ThresholdsProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ThresholdsProfilesRepository extends JpaRepository<ThresholdsProfiles,String> {
    Optional<ThresholdsProfiles> findByThresProfileId(String Thres_profile_id);
    @Query(value = "SELECT user_id FROM itn_thresholds_profiles ORDER BY modified_on  DESC LIMIT 1", nativeQuery = true)
    String findLastThreshProfileId();
}
