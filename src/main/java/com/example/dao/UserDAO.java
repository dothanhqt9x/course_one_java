package com.example.dao;

import com.example.entity.UserEntity;
import com.example.entity.UserKey;

import java.util.List;

public interface UserDAO {

    void createUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(int id);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserKey userKey);
}
