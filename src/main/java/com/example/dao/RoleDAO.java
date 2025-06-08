package com.example.dao;

import com.example.entity.RoleEntity;

import java.util.List;

public interface RoleDAO {

    void saveRole(RoleEntity roleEntity);

    List<RoleEntity> getAllRole();

    RoleEntity getRoleById(int id);

    void updateRole(RoleEntity roleEntity);

    void deleteRole(int id);
}
