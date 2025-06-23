package com.btspring.btspring2.service;

import com.btspring.btspring2.model.entity.UserProductEntity;

import java.util.List;

public interface UserProductService {
    void save(UserProductEntity userProductEntity);

    List<UserProductEntity> findByUserId(int id);

    UserProductEntity  findByUserIdAndProductId(int id, int productId);
}
