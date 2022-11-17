package com.group12.bizwiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.group12.bizwiz.models.Product;
import com.group12.bizwiz.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//Create
	public Product addProduct(Product p) {
		return productRepo.save(p);
	}

	//Read
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	//Update
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}
	
	//Delete
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	//VALIDATION
	public Product validateProduct(Product newProduct, BindingResult result) {
		Optional<Product> potentialProduct = productRepo.findByDescription(newProduct.getDescription());
		
		if(potentialProduct.isPresent()) {
			result.rejectValue("description", "Exists","Product with this description already exists");
		}
		if(result.hasErrors()) {
			return null;
		}
		return newProduct;
	}
	
}
