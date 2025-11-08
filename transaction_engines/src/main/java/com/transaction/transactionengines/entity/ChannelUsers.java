package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Table(name="itn_channel_users")
public class ChannelUsers implements UserDetails {

    @Id
    @Column(name = "user_id", length = 20, nullable = false)
    private String userId ;
    private String user_name ;
    private String password ;
    private String txn_pin ;
    private int invalid_pin_count ;
    private int invalid_password_count;
    private String category_code ;
    private String user_type ;
    private String first_name;
    private String last_name ;
    private String msisdn ;
    private String status ;
    private String firm_name;
    private String  alter_msisdn ;
    @Column(name = "email_id")
    private String emailId;
    private String city ;
    private String state ;
    private String district ;
    private String address ;
    private String pan ;
    private String pincode ;
    private String parent_id ;
    private String owner_id ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "thres_profile_id",unique = true)
    private ThresholdsProfiles thresholdsProfiles ;
    private LocalDateTime join_date ;
    private LocalDateTime deleted_on ;
    private ZonedDateTime modified_on ;
    private String suspension_reason ;
    private ZonedDateTime last_login_on ;
    private String first_login ;
    private String suspend_reason;
    private String manager ;
    private String otp_status ;
    private String dmt_type ;
    private String pan_file_path ;
    private String aadhar_file_path ;
    private String gst_number ;
    private String aadhaar ;
    private String incometax_proof_name ;
    private String incometax_proof_id ;
    private String incometax_proof_file;
    private String servicetax_proof_name ;
    private String servicetax_proof_id ;
    private String servicetax_proof_file ;
    private String id_proof_name ;
    private String id_proof_id ;
    private String id_proof_file ;
    private String address_proof_name ;
    private String address_proof_id ;
    private String address_proof_file ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
