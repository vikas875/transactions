package com.transaction.transactionengines.dto;



import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class RegisterRequest {

    private String user_id ;
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
    private String emailId;
    private String city ;
    private String state ;
    private String district ;
    private String address ;
    private String pan ;
    private String pincode ;
    private String parent_id ;
    private String owner_id ;
    private String thres_profile_id ;
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

}
