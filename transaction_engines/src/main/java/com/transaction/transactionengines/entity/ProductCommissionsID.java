package com.transaction.transactionengines.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductCommissionsID implements Serializable {
    private String product_id ;
    private String product_type;
    private String service_provider;
    private String recharge_type;
    private String user_type ;
    private String user_category;
}
