package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_subscriber_wallet")
public class SubscriberWallet {
    @Id
    private String wallet_id;
    @Column(name = "subscriber_id")
    private String subscriberId;
    @Column(name = "user_type")
    private String userType ;
    private String msisdn ;
    private String wallet_type;
    @Column(name = "prev_balance")
    private long prevBalance ;
    private long balance ;
    private long net_credit ;
    private long net_debit;
    @Column(name = "last_transation_type")
    private String lastTransationType ;
    @Column(name = "last_transation_id")
    private String lastTransationId ;
    private String status ;
    private long wallet_limit ;
    @Column(name = "last_transation_on")
    private LocalDateTime lastTransationOn ;
    private String operator_Code ;
    private LocalDateTime first_transation_on ;
}
