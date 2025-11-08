package com.transaction.transactionengines.entity;

import com.transaction.transactionengines.enums.SubscriberStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="itn_subscribers")
public class Subscribers {
    @Id
    @Column(name = "subscriber_id", length = 20, nullable = false)
    private String subscriberId;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email_id", length = 200, unique = true)
    @Email(message = "Invalid email format")
    private String emailId;

    @Column(name = "msisdn", length = 10,nullable = false)
    @Pattern(regexp = "\\d{10}", message = "MSISDN must be a 10-digit number")
    private String msisdn;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10,nullable = false)
    private SubscriberStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thres_profile_id",unique = true)
    private ThresholdsProfiles thresholdsProfiles ;

    @Column(name = "otp", length = 6)
    private String otp;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "deleted_on")
    private LocalDateTime deletedOn;

    @Column(name = "last_modified_on")
    private LocalDateTime lastModifiedOn;

}
