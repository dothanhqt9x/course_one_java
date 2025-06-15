package com.example.demo.mapper;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public List<ProductResponseDTO> toResponseDTOs(List<Product> products) {
        return products.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
