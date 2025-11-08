package com.transaction.transactionengines.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetailsID implements Serializable {
    private String detail_id ;
    private String user_category;
}
