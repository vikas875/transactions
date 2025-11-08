package com.transaction.transactionengines.services.subscriber;

import com.transaction.transactionengines.dto.SubscriberDto;
import com.transaction.transactionengines.entity.Subscribers;
import com.transaction.transactionengines.exceptions.InvalidSubscriberException;
import com.transaction.transactionengines.repository.SubscriberRepository;

import com.transaction.transactionengines.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService{

   private final SubscriberRepository subscriberRepository;
   private final IdGenerator IdGenerator;

    @Override
    public Subscribers validateSubscriber(String subscriberId) {
        return subscriberRepository.findBySubscriberId(subscriberId)
                .filter(s -> "Active".equalsIgnoreCase(s.getStatus().toString()))
                .orElseThrow(() -> new InvalidSubscriberException("Invalid or inactive subscriber"));
    }

    @Override
    public void addSubscriber(SubscriberDto subscriberDto) {
        Subscribers newSubscriber =  new Subscribers();
        newSubscriber.setSubscriberId(IdGenerator.generateSubscriberId());
        newSubscriber.setFirstName(subscriberDto.getFirstName());
        newSubscriber.setLastName(subscriberDto.getLastName());
        newSubscriber.setEmailId(subscriberDto.getEmailId());
        newSubscriber.setMsisdn(subscriberDto.getMsisdn());
        newSubscriber.setStatus(subscriberDto.getStatus());
        subscriberRepository.save(newSubscriber);
    }
}
