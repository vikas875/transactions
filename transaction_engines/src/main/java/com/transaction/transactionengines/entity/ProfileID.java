package com.transaction.transactionengines.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProfileID implements Serializable {
    private String profile_id ;
    private int version ;
}
