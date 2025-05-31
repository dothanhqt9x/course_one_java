package com.example;

import com.example.dao.RoleDAO;
import com.example.dao.impl.RoleDAOImpl;
import com.example.dao.impl.UserDAOImpl;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.entity.UserKey;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserKey(new UserKey(1, "nva"));
        userEntity.setName("Nguyen Van A");
        userEntity.setUsername("nguyenvana");
        userEntity.setPassword("$2a$12$HmVdNUhE7MOyEevye2z2FesDXOWQ2OXSeH4.Y9hm6JhsDHlJTFJvO");

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setUserKey(new UserKey(2, "nvb"));
        userEntity2.setName("Nguyen Van B");
        userEntity2.setUsername("nguyenvanb");
        userEntity2.setPassword("$2a$12$/9PAzh0pzuVcS9yO2loLGeNCRzqsQWQZlDRAWli.9P6ckrgku.WCS");

        UserDAOImpl userDAOImpl = new UserDAOImpl();

        userDAOImpl.createUser(userEntity);
        userDAOImpl.createUser(userEntity2);

        //
        RoleEntity  roleEntity = new RoleEntity();
        roleEntity.setId(1);
        roleEntity.setName("Admin");

        RoleEntity  roleEntity2 = new RoleEntity();
        roleEntity2.setId(2);
        roleEntity2.setName("User");

        RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
        roleDAOImpl.createRole(roleEntity);
        roleDAOImpl.createRole(roleEntity2);



        //
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntity);

        userEntity.setRoles(roles);
        userDAOImpl.updateUser(userEntity);

        roles.clear();

        roles.add(roleEntity2);
        userEntity2.setRoles(roles);


        userDAOImpl.updateUser(userEntity2);
        //
        for(UserEntity user : userDAOImpl.getAllUser()) {
            System.out.println(user);
        }

        //
        logger.info("sau khi update user");
        userEntity.setName("Nguyen Van A Update");
        userEntity2.setName("Nguyen Van B Update");

        userDAOImpl.updateUser(userEntity);
        userDAOImpl.updateUser(userEntity2);

        for(UserEntity user : userDAOImpl.getAllUser()) {
            System.out.println(user);
        }


        //
        UserEntity user3 = new UserEntity();
        user3.setUserKey(new UserKey(3, "nvc"));
        user3.setName("Nguyen Van C");
        user3.setUsername("nguyenvanc");
        user3.setPassword("pass");

        userDAOImpl.createUser(user3);

        //
        userDAOImpl.deleteUser(new UserKey(3, "nvc"));



    }
}