package io.espinoleandroo.java.Spring.domain.repository;

import java.util.List;
import java.util.Optional;

import io.espinoleandroo.java.Spring.domain.Product;

public interface ProductRepository {

	List<Product> getAll();
	Optional<List<Product>> getByCategory(int idCategory);
	Optional<List<Product>> getScarseProducts(int quantity);
	Optional<Product> getProduct(int productId);
	Product save(Product product);
	void delete(int productId);
	
}
