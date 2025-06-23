package com.btspring.btspring2.repository;

import com.btspring.btspring2.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findByName(String name);

    List<ProductEntity> findAllByName(String name);
}
