package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itn_mnytfr_srvchrg_dtls")
public class MoneyTransferServiceChargeDetails {
    @EmbeddedId
    private ServiceChargeDetailsID serviceChargeDetailsID;
    private String type ;
    private String usr_ctgry_1 ;
    private long srvc_amt_1 ;
    private String usr_ctgry_2 ;
    private long srvc_amt_2;
    private String  usr_ctgry_3 ;
    private long srvc_amt_3 ;
    private String usr_ctgry_4 ;
    private long srvc_amt_4 ;
    private String usr_ctgry_5 ;
    private long srvc_amt_5 ;
    private String status ;
}
