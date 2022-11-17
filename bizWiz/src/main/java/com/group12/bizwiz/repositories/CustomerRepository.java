package com.group12.bizwiz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.group12.bizwiz.models.Customer;

public interface CustomerRepository extends CrudRepository <Customer,Long> {
	
	List<Customer> findAll();
	
	Optional<Customer> findById(Long id);
	
	Optional<Customer> findBycustomerName(String customerName);
	
	List<Customer> findAllByOrderByNameAsc();

}
