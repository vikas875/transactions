package com.transaction.transactionengines.services.authentication;

import com.transaction.transactionengines.dto.RegisterRequest;
import com.transaction.transactionengines.dto.ChannelUserDto;

public interface AuthenticationService {
    ChannelUserDto createCustomer(RegisterRequest registerRequest);
    boolean hasCustomerWithEmail(String email);

}
