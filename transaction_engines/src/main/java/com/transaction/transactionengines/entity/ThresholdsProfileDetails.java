package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="itn_thresholds_profile_dtls")
public class ThresholdsProfileDetails {
    @Id
    private String thres_profile_dtls_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thres_profile_id",unique = true)
    private ThresholdsProfiles thresholdsProfiles ;
    @Column(name = "group_id")
    private String groupId ;
    @Column(name = "payer_count")
    private long payerCount ;
    @Column(name = "payer_amt")
    private long payerAmt ;
    @Column(name = "payee_count")
    private long payeeCount;
    @Column(name="payee_amt")
    private long payeeAmt ;
}
