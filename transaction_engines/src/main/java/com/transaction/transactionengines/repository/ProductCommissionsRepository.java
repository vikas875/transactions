package com.transaction.transactionengines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transaction.transactionengines.entity.ProductCommissions;
import org.springframework.stereotype.Repository;
import com.transaction.transactionengines.entity.ProductCommissionsID;

@Repository
public interface ProductCommissionsRepository extends JpaRepository<ProductCommissions,ProductCommissionsID>{
}
