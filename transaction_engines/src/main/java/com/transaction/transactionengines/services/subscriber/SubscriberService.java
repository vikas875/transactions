package com.transaction.transactionengines.services.subscriber;

import com.transaction.transactionengines.dto.SubscriberDto;
import com.transaction.transactionengines.entity.Subscribers;

public interface SubscriberService {
    Subscribers validateSubscriber(String subscriberId);
    void addSubscriber(SubscriberDto subscriberDto);
}
