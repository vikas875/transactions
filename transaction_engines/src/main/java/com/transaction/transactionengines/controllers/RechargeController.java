package com.transaction.transactionengines.controllers;

import com.transaction.transactionengines.dto.RechargeRequest;
import com.transaction.transactionengines.entity.TransactionHeader;
import com.transaction.transactionengines.services.recharge.RechargeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction/recharge")
public class RechargeController {
    private final RechargeService rechargeService;

    @PostMapping("/dorecharge")
    public ResponseEntity<TransactionHeader> recharge(@Valid @RequestBody RechargeRequest request) {
        TransactionHeader result = rechargeService.processRecharge(request);
        return ResponseEntity.ok(result);
    }
}
