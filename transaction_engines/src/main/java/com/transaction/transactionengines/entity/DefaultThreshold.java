package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itn_default_threshold")
public class DefaultThreshold {
    @Id
    private String set_default_id ;
    private String thres_profile_id;
    private String threshold_name ;
    private String user_type ;
    private String category_code ;
    private String status ;
}
