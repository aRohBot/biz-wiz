package com.group12.bizwiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.group12.bizwiz.models.Customer;
import com.group12.bizwiz.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	//Create
	public Customer create(Customer c) {
		return customerRepo.save(c);
	}

	//Read
	public List<Customer> all(){
		return customerRepo.findAll();
	}
	
	public Customer findCutomerById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}
	
	//Update
	public Customer update(Customer c) {
		return customerRepo.save(c);
	}
	
	//Delete
	public void destroy(Long id) {
		customerRepo.deleteById(id);
	}
	
	//VALIDATION
	public Customer validate(Customer newCustomer, BindingResult result) {
		Optional<Customer> potentialCustomer = customerRepo.findBycustomerName(newCustomer.getCustomerName());
		
		if(potentialCustomer.isPresent()) {
			result.rejectValue("customerName", "Exists","Customer with this  name already exists");
		}
		if(result.hasErrors()) {
			return null;
		}
		return newCustomer;
	}
	
}
