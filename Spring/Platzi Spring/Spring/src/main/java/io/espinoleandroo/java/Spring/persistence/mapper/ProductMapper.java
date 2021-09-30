package io.espinoleandroo.java.Spring.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import io.espinoleandroo.java.Spring.domain.Product;
import io.espinoleandroo.java.Spring.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

	@Mappings({
		 @Mapping(source = "idProducto", target = "productId"),
		 @Mapping(source = "nombre", target = "name"),
		 @Mapping(source = "idCategoria", target = "categoryId"),
		 @Mapping(source = "precioVenta", target = "price"),
		 @Mapping(source = "catidadStock", target = "stock"),
		 @Mapping(source = "estado", target = "active"),
		 @Mapping(source = "categoria", target = "category"),
	})
	Product toProduct(Producto producto);
	List<Product> toProducts(List<Producto> productos);
	
	@InheritInverseConfiguration
	@Mapping(target = "codigoBarras", ignore = true)
	Producto toProduct(Product product);
	
}
