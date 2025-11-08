package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_product_commissions")
public class ProductCommissions {
    @EmbeddedId
    private ProductCommissionsID productCommissionsID;
    private String commissionType;
    private String commissionDirection ;
    private long commission;
    private LocalDateTime createdOn ;
    private ZonedDateTime modifiedOn ;
    private String status;
}
