package com.btspring.btspring2.service.impl;

import com.btspring.btspring2.model.entity.UserProductEntity;
import com.btspring.btspring2.repository.UserProductRepository;
import com.btspring.btspring2.service.UserProductService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserProductServiceImpl implements UserProductService {

    private UserProductRepository userProductRepository;
    public UserProductServiceImpl(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    @Override
    public void save(UserProductEntity userProductEntity) {
        userProductRepository.save(userProductEntity);
    }

    @Override
    public List<UserProductEntity> findByUserId(int id) {
        return userProductRepository.findByUserId(id);
    }

    @Override
    public UserProductEntity findByUserIdAndProductId(int id, int productId) {
        return userProductRepository.findByUserIdAndProductId(id, productId);
    }
}
