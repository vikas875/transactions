package com.transaction.transactionengines.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import lombok.Data;

@Entity
@Data
@Table(name="itn_service_charge_profile")
public class ServiceChargeProfile {
    @EmbeddedId
    private ProfileID profileID;
    private String detail_id ;
    private ZonedDateTime created_on;
    private ZonedDateTime modified_on = ZonedDateTime.now();
    private String status;
}
