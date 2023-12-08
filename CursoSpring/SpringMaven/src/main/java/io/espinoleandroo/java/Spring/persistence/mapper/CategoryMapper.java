package io.espinoleandroo.java.Spring.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import io.espinoleandroo.java.Spring.domain.Category;
import io.espinoleandroo.java.Spring.persistence.entity.Categoria;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mappings({
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active")
	})
	Category toCategory(Categoria categoria);
	
	@InheritInverseConfiguration
	Categoria toCategoria(Category category);
}
