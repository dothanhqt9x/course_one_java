package com.btspring.btspring2.service;

import com.btspring.btspring2.model.dto.request.ProductRequestDTO;
import com.btspring.btspring2.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity getProductById(int id);

    List<ProductEntity> getAllProducts();

    void addProduct(ProductRequestDTO productRequestDTO);

    List<ProductEntity> getProductByName(String name);
}
