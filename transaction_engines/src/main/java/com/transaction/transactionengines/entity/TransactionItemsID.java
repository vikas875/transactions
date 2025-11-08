package com.transaction.transactionengines.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class TransactionItemsID implements Serializable {
    private String transfer_id ;
    private String party_id ;
    private String second_party ;
    private String transaction_type ;
}
