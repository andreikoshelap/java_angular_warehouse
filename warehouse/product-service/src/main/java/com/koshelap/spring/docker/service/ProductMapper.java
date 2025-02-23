package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.OrderDTO;
import com.koshelap.spring.docker.dto.ProductDTO;
import com.koshelap.spring.docker.model.Inventory;
import com.koshelap.spring.docker.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Inventory product);

    Inventory productDTOToProduct(ProductDTO productDTO);
}
