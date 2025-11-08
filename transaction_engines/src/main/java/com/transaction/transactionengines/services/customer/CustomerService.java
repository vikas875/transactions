package com.transaction.transactionengines.services.customer;

import com.transaction.transactionengines.entity.ChannelUsers;
import com.transaction.transactionengines.entity.ITNProductProfile;
import com.transaction.transactionengines.entity.ThresholdsProfiles;

public interface CustomerService {

    ChannelUsers validateChannelUser(String userId);
    ITNProductProfile validateProductProfile(String productCode);
    boolean validateThresholds(String userId);
    ThresholdsProfiles fetchThresholdsProfile(String userId);
}
