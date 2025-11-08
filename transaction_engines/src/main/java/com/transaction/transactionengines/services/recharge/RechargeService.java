package com.transaction.transactionengines.services.recharge;

import com.transaction.transactionengines.dto.RechargeRequest;
import com.transaction.transactionengines.entity.TransactionHeader;

public interface RechargeService {
   TransactionHeader processRecharge(RechargeRequest request);
}
