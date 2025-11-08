package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itn_thresholds_profiles")
public class ThresholdsProfiles {
    @Id
    @Column(name = "thres_profile_id" ,length = 30, nullable = false)
    private String thresProfileId ;
    private String name ;
    private String user_type ;
    private String status;

    public int getDailyCount(){
        return 1;
    }
    public int getDailyLimit(){
        return 1;
    }
}
