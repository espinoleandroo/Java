package io.espinoleandroo.java.Spring.persistence;

import java.util.List;
import java.util.Optional;

import io.espinoleandroo.java.Spring.persistence.crud.ProductoCrudRepository;
import io.espinoleandroo.java.Spring.persistence.entity.Producto;

public class ProductoRepository {

	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
	public List<Producto> getByCategoria(int idCategoria){
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad){
		return productoCrudRepository.findByCatidadStockLessThanAndEstado(cantidad, true);
	}
}
