package io.espinoleandroo.java.Spring.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.espinoleandroo.java.Spring.domain.Product;
import io.espinoleandroo.java.Spring.domain.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository; 
	
	public List<Product> getAll(){
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(int productId){
		return productRepository.getProduct(productId);
	}
	
	public Optional<List<Product>> getByCategory(int categoryId){
		return productRepository.getByCategory(categoryId);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public boolean delete(int productId) {
		return getProduct(productId).map(product -> {
			productRepository.delete(productId);
			return true;
		}).orElse(false);
	}
}
