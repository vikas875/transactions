package com.transaction.transactionengines.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductID implements Serializable {
    @Column(name = "product_type", length = 20)
    private String productType;

    @Column(name = "service_provider", length = 75)
    private String serviceProvider;

    @Column(name = "recharge_type", length = 50)
    private String rechargeType;

    @Column(name = "product_code", length = 50)
    private String productCode;

    @Column(name = "api", length = 20)
    private String api;
}
