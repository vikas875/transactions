package com.transaction.transactionengines.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="sys_service_types")
public class ServiceTypes {
    @Id
    @Column(name = "service_type",length = 30,nullable = false)
    private String serviceType ;
    @Column(name = "service_name",length = 20)
    private String serviceName;
    private String status;
    private String is_financial;
}
