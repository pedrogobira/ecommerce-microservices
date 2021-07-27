package com.pedrogobira.productcatalog.mapper;

import com.pedrogobira.productcatalog.dto.ProductDto;
import com.pedrogobira.productcatalog.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);
}
