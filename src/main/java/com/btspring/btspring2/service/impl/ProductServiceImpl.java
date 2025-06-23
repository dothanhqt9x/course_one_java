package com.btspring.btspring2.service.impl;

import com.btspring.btspring2.convert.ProductMapper;
import com.btspring.btspring2.model.dto.request.ProductRequestDTO;
import com.btspring.btspring2.model.entity.ProductEntity;
import com.btspring.btspring2.repository.ProductRepository;
import com.btspring.btspring2.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ProductEntity getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> listProduct = productRepository.findAll();
        return listProduct;
    }

    @Override
    public void addProduct(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = productMapper.toProductEntity(productRequestDTO);
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getProductByName(String name) {
        List<ProductEntity> list = productRepository.findAllByName(name);
        return list;
    }


}
