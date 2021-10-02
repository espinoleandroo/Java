package io.espinoleandroo.java.Spring.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.espinoleandroo.java.Spring.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

	List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer catidadStock, Boolean estado);
}
