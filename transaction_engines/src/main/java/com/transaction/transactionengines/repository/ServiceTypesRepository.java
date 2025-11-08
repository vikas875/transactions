package com.transaction.transactionengines.repository;


import com.transaction.transactionengines.entity.ServiceTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceTypesRepository extends JpaRepository<ServiceTypes, String> {
    Optional<ServiceTypes> findByServiceName(String serviceName);
    Optional<ServiceTypes> findByServiceNameAndStatus(String serviceName, String status);
}
