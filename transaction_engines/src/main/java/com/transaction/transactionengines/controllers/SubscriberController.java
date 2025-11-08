package com.transaction.transactionengines.controllers;

import com.transaction.transactionengines.dto.SubscriberDto;
import com.transaction.transactionengines.services.subscriber.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction/subscribe")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService;

    @PostMapping("/addSubscriber")
    public ResponseEntity<?> addSubscriber( @RequestBody  SubscriberDto subscriberDto) {
     subscriberService.addSubscriber(subscriberDto);
     return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
