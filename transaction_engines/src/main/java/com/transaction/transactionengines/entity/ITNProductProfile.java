package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

@Entity
@Data
@Table(name="itn_product_profile")
public class ITNProductProfile {

    @EmbeddedId

    private ProductID productId;

    @Column(name = "product_Id", length = 20)
    private String productIdValue;

    @Column(name = "margin_Type", length = 20)
    private String marginType;

    @Column(name = "margin")
    private long margin;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "modified_On" )
    private ZonedDateTime modifiedOn;
}
