package com.btspring.btspring2.repository;

import com.btspring.btspring2.model.entity.UserProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProductEntity, Integer> {
    List<UserProductEntity> findByUserId(int userId);

    UserProductEntity findByUserIdAndProductId(int userId, int productId);
}
