package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="sys_product_profiles")
public class SYSProductProfiles {
    @Id
    private String product_id ;
    private String product_type;
    private String service_provider ;
    private String recharge_type;
    private String product_code;
    private String api ;
    private String status ;
    private LocalDateTime created_on ;
    private String image_url ;
}
