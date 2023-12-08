package io.espinoleandroo.java.Spring.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.espinoleandroo.java.Spring.domain.Product;
import io.espinoleandroo.java.Spring.domain.repository.ProductRepository;
import io.espinoleandroo.java.Spring.persistence.crud.ProductoCrudRepository;
import io.espinoleandroo.java.Spring.persistence.entity.Producto;
import io.espinoleandroo.java.Spring.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository{

	@Autowired
	private ProductoCrudRepository productoCrudRepository;
	@Autowired
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll(); 
		return mapper.toProducts(productos); 
	}
	
	@Override
	public void delete(int idProducto) {
		productoCrudRepository.deleteById(idProducto);
	}

	@Override
	public Optional<List<Product>> getByCategory(int idCategory) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategory); 
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}
}
