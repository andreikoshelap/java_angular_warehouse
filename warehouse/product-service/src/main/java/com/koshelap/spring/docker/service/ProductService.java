package com.koshelap.spring.docker.service;

import com.koshelap.spring.docker.dto.ProductDTO;
import com.koshelap.spring.docker.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final InventoryRepository repository;
    private final ProductMapper productMapper;


    public ProductService(InventoryRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }
}
