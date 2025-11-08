package com.transaction.transactionengines.dto;

import lombok.Data;
@Data
public class AuthenticationResponse {
    private String token_type = "Bearer";
    private String access_token;
    private long expires_in;
    private String refresh_token;
    private String issued_at;
    private String userId;

}
