package com.retail.billing.repository;

import com.retail.billing.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRespository extends CrudRepository<Customer,Long> {

    Customer findByCustomerId(Long customerId);

}
