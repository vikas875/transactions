package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itn_service_charge_details")
public class ServiceChargeDetails {
    @EmbeddedId
    private DetailsID detailsID;
    private int version ;
    private String service_type ;
    private String product_type ;
    private String service_provider ;
    private String recharge_type;
    private String srvc_chrg_type ;
    private long service_charge ;
    private String status;
}
