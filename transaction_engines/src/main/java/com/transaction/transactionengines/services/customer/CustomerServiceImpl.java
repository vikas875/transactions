package com.transaction.transactionengines.services.customer;

import com.transaction.transactionengines.entity.ChannelUsers;
import com.transaction.transactionengines.entity.ITNProductProfile;

import com.transaction.transactionengines.entity.ThresholdsProfiles;
import com.transaction.transactionengines.exceptions.InvalidChannelUserException;

import com.transaction.transactionengines.repository.ChannelUsersRepository;
import com.transaction.transactionengines.repository.ITNProductProfileRepository;
import com.transaction.transactionengines.repository.ThresholdsProfilesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{


    ChannelUsersRepository channelUsersRepository;
    ThresholdsProfilesRepository thresholdsProfilesRepository;
    ITNProductProfileRepository itnProductProfileRepository;



    @Override
    public ChannelUsers validateChannelUser(String userId) {
        return channelUsersRepository.findByUserId(userId)
                .filter(u -> u.isEnabled())
                .orElseThrow(() -> new InvalidChannelUserException("Invalid channel user"));
    }

    @Override
    public ITNProductProfile validateProductProfile(String productId) {
        return itnProductProfileRepository.findByProductIdValue(productId)
                .orElseThrow(() -> new RuntimeException("Invalid product profile"));
    }

    @Override
    public boolean validateThresholds(String Thres_Profile_id) {
        ThresholdsProfiles profile = thresholdsProfilesRepository.findByThresProfileId(Thres_Profile_id)
                .orElseThrow(() -> new RuntimeException("Threshold profile not found"));

        // Example logic: check if user crossed limits
        if (profile.getDailyCount() > profile.getDailyLimit()) {
            throw new RuntimeException("Daily threshold exceeded");
        }
        return true;
    }

    @Override
    public ThresholdsProfiles fetchThresholdsProfile(String Thres_Profile_id) {
        return thresholdsProfilesRepository.findByThresProfileId(Thres_Profile_id)
                .orElseThrow(() -> new RuntimeException("Threshold profile not found"));
    }
}
