package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	public void add(Product product) {
		productRepository.save(product);
	}
	
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Transactional
	public void addAll(Collection<Product> products) {
		productRepository.saveAll(products);
	}
	
	@Transactional(readOnly = true)
	public List<Product> findByNameIs(String name) {
		return productRepository.findByName(name);
	}
	
	@Transactional(readOnly = true)
	public List<Product> findByNameContainingIgnoreCase(String searchString) {
		return productRepository.findByNameContainingIgnoreCase(searchString);
	}
}
