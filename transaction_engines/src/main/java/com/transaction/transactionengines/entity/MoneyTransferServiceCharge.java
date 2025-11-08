package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_mnytfr_srvchrg")
public class MoneyTransferServiceCharge {
    @Id
    private String srvc_chrg_id ;
    private int srvc_chrg_ver ;
    private long min_tfr_amt ;
    private long max_tfr_amt ;
    private String mode ;
    private String srvc_chrg_dtls_id ;
    private ZonedDateTime created_on ;
    private String status ;
}
