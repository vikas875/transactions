package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_service_charge")
public class ServiceCharge {
    @Id
    private String srvc_chrg_id ;
    private String service_type ;
    private String srvc_chrg_type ;
    private String service_charge;
    private String payer ;
    private String productId;
    private String product_type ;
    private String service_provider ;
    private  String recharge_type;
    private LocalDateTime created_on ;
    private ZonedDateTime modified_on ;
    private String status;
}
