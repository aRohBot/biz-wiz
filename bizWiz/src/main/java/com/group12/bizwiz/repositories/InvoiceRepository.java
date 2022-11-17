package com.group12.bizwiz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.group12.bizwiz.models.Invoice;

public interface InvoiceRepository  extends CrudRepository<Invoice, Long> {

	List<Invoice> findAll();
	
	Optional<Invoice> findById(Long id);

}
