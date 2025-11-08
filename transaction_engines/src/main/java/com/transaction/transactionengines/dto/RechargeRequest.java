package com.transaction.transactionengines.dto;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
@Data
public class RechargeRequest {
    @NotNull(message = "Service cannot be null")
    private String service;
    @NotNull(message = "Payer User ID is required")
    private String payerUserId;
    @NotNull(message = "Payee User ID is required")
    private String payeeUserId;
    @NotNull(message = "Amount must not be null")
    private double amount;
    @NotNull(message = "Product ID is required")
    private String productId;
}
