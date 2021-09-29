package io.espinoleandroo.java.Spring.persistence;

import java.util.List;

import io.espinoleandroo.java.Spring.persistence.crud.ProductoCrudRepository;
import io.espinoleandroo.java.Spring.persistence.entity.Producto;

public class ProductoRepository {

	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
}
