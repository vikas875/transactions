package com.transaction.transactionengines.services.Thresholds;

import com.transaction.transactionengines.entity.ThresholdsProfiles;
import com.transaction.transactionengines.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThresholdsProfilesServiceImpl implements ThresholdsProfilesService{
     private final IdGenerator idGenerator;
    @Override
    public ThresholdsProfiles getDefalutThresholds() {
        ThresholdsProfiles thresholdsProfiles = new ThresholdsProfiles();
        thresholdsProfiles.setThresProfileId(idGenerator.generateThresholdsId());
        thresholdsProfiles.setName("Bronze");
        thresholdsProfiles.setStatus("Y");
        thresholdsProfiles.setUser_type("CHANNEL");
        return thresholdsProfiles;
    }
}
