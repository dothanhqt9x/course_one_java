package com.btspring.btspring2.service;

import com.btspring.btspring2.model.dto.request.UserRequestDTO;
import com.btspring.btspring2.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    void addUser(UserRequestDTO user);

    void updateUser(int id, UserRequestDTO user);

    void deleteUser(int id);

    List<UserEntity> getUsers();

    UserEntity getUserById(int id);
}
