package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_transaction_header")
public class TransactionHeader {
    @Id
    @Column(name = "transfer_id")
    private String transferId;
    @Column(name = "transfer_on")
    private LocalDateTime transferOn ;
    @Column(name = "payer_user_id")
    private String payerUserId ;
    private String payer_account_id;
    @Column(name = "payee_user_id")
    private String payeeUserId ;
    private String payee_account_id;
    @Column(name = "requested_value")
    private long requestedValue;
    private String error_code ;
    @Column(name = "transfer_status")
    private String transferStatus ;
    private String service_type;
    private String product_id;
    private String service_provider ;
    private String product_type;
    private String recharge_type;
    private String reconciliation_done ;
    private String reconciliation_date ;
    private String reconciliation_by;
    private String details_1 ;
    private String details_2 ;
    private String details_3 ;
    private String details_4 ;
    private String details_5 ;
    private String created_by ;
    private String created_on ;
    private String modified_by ;
    private ZonedDateTime modified_on ;
    private String remarks;
    private long total_commission;
    private long admn_srvc_chrg;
    private long dist_srvc_chrg;
    private long rtlr_srvc_chrg;
    private long total_service_charge ;
    private String operator_txn_id ;
    private String aggregator_txn_id ;
    private String details_6 ;
    private String details_7 ;
    private String details_8 ;
    private String details_9 ;
    private String details_10 ;
    private long tax_details_1;
    private long tax_details_2 ;
    private long tax_details_3;
    private long tax_details_4 ;
    private long tax_details_5 ;
    private long tax_details_6 ;
    private long tax_details_7 ;
    private long tax_details_8;
    private String aggregator_status ;
    private String dmt_api ;
}
