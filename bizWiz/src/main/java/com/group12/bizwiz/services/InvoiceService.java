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
	public Invoice addInvoice(Invoice i) {
		return invoiceRepo.save(i);
	}

	//Read
	public List<Invoice> allInvoices(){
		return invoiceRepo.findAll();
	}
	
	public Invoice findInvoiceById(Long id) {
		return invoiceRepo.findById(id).orElse(null);
	}
	
	//Update
	public Invoice updateInvoice(Invoice i) {
		return invoiceRepo.save(i);
	}
	
	//Delete
	public void deleteInvoice(Long id) {
		invoiceRepo.deleteById(id);
	}
	
	//VALIDATION
	public Invoice validateInvoice(Invoice newProduct, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		return newProduct;
	}
	
	
}
