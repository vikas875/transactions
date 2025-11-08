package com.transaction.transactionengines.dto;

import com.transaction.transactionengines.enums.SubscriberStatus;
import lombok.Data;

@Data
public class SubscriberDto {



    private String firstName;

    private String lastName;

    private String emailId;

    private String msisdn;

    private SubscriberStatus status;
}
