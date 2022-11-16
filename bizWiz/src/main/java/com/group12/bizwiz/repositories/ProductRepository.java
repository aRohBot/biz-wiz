package com.group12.bizwiz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.group12.bizwiz.models.Product;

public interface ProductRepository extends CrudRepository <Product,Long> {

	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	Optional<Product> findByDescription(String description);
	
}
