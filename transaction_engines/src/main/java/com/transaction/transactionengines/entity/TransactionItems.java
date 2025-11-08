package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_transaction_items")
public class TransactionItems {
   @EmbeddedId
    private TransactionItemsID transactionItemsID;
    private ZonedDateTime transfer_on ;
    private String transfer_status;
    private String user_type ;
    private String user_category ;
    private long approved_value;
    private String service_type;
    private String product_id ;
    private String service_provider;
    private String product_type ;
    private String recharge_type;
    private long previous_balance;
    private long post_balance ;
}
