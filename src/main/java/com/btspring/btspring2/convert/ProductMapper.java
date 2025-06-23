package com.btspring.btspring2.convert;

import com.btspring.btspring2.model.dto.request.ProductRequestDTO;
import com.btspring.btspring2.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductEntity toProductEntity(ProductRequestDTO productRequestDTO);
    ProductRequestDTO toProductRequestDTO(ProductEntity productEntity);

}
