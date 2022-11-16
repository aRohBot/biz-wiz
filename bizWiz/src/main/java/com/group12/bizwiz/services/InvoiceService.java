package com.group12.bizwiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.group12.bizwiz.models.Invoice;
import com.group12.bizwiz.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	//Create
	public Invoice create(Invoice i) {
		return invoiceRepo.save(i);
	}

	//Read
	public List<Invoice> all(){
		return invoiceRepo.findAll();
	}
	
	public Invoice findProductById(Long id) {
		return invoiceRepo.findById(id).orElse(null);
	}
	
	//Update
	public Invoice update(Invoice i) {
		return invoiceRepo.save(i);
	}
	
	//Delete
	public void destroy(Long id) {
		invoiceRepo.deleteById(id);
	}
	
	//VALIDATION
	public Invoice validate(Invoice newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		return newProduct;
	}
	
	
}
