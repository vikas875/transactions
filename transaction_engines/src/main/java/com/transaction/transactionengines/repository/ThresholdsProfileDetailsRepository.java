package com.transaction.transactionengines.repository;

import com.transaction.transactionengines.entity.ThresholdsProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThresholdsProfileDetailsRepository extends JpaRepository<ThresholdsProfileDetails,String> {
    @Query("SELECT t FROM ThresholdsProfileDetails t WHERE t.thresholdsProfiles.thresProfileId = :thresholdsProfilesId")
    Optional<ThresholdsProfileDetails> findByThresholdsProfiles(String thresholdsProfilesId);
    @Query("SELECT t.payerAmt FROM ThresholdsProfileDetails t " +
            "WHERE t.thresholdsProfiles.thresProfileId = :thresholdsProfilesId " +
            "AND t.groupId = :groupId")
    long findByThresholdsProfilesAndGroupId(String thresholdsProfilesId,String groupId);

}
