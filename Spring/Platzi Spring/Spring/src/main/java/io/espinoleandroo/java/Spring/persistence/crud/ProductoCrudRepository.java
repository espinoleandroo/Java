package io.espinoleandroo.java.Spring.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import io.espinoleandroo.java.Spring.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

}
