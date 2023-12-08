package io.espinoleandroo.java.Spring.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import io.espinoleandroo.java.Spring.domain.PurchaseItem;
import io.espinoleandroo.java.Spring.persistence.entity.ComprasProducto;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
	
	@Mappings({
        @Mapping(source = "id.idProducto", target = "productId"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "estado", target = "active")
	})
	PurchaseItem toPurchaseItem(ComprasProducto producto);
	
	@InheritInverseConfiguration
	ComprasProducto toComprasProducto(PurchaseItem item);
}
