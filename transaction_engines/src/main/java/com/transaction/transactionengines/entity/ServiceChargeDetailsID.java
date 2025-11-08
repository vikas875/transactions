package com.transaction.transactionengines.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ServiceChargeDetailsID implements Serializable {
    private String srvc_chrg_dtls_id ;
    private long from_amt ;
    private long to_amt ;
}
