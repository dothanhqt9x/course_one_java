package com.example.dao;

import com.example.entity.UserEntity;
import com.example.entity.UserKey;
import org.hibernate.Session;

import java.util.List;

public interface UserDAO {

    void saveUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(int id);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserKey userKey);


    List<UserEntity> getUserByName(String name);

    List<UserEntity> getUserByNameAndRole(String name, String role);
}
