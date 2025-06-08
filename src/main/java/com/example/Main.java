package com.example;

import com.example.criteria.GetUserByName;
import com.example.dao.UserDAO;
import com.example.dao.impl.PermissionImpl;
import com.example.dao.impl.RoleDAOImpl;
import com.example.dao.impl.UserDAOImpl;
import com.example.entity.PermissionEntity;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.entity.UserKey;

import java.util.List;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        UserEntity user1 = new UserEntity();
        user1.setUserKey(new UserKey(1, "nva"));
        user1.setName("Nguyen Van A");
        user1.setUsername("nguyenvana");
        user1.setPassword("$2a$12$HmVdNUhE7MOyEevye2z2FesDXOWQ2OXSeH4.Y9hm6JhsDHlJTFJvO");

        UserEntity user2 = new UserEntity();
        user2.setUserKey(new UserKey(2, "nvb"));
        user2.setName("Nguyen Van B");
        user2.setUsername("nguyenvanb");
        user2.setPassword("$2a$12$/9PAzh0pzuVcS9yO2loLGeNCRzqsQWQZlDRAWli.9P6ckrgku.WCS");


        //
        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setId(1);
        roleAdmin.setName("Admin");

        RoleEntity roleUser = new RoleEntity();
        roleUser.setId(2);
        roleUser.setName("User");


        //cascade user-role
        user1.getRoles().add(roleAdmin);
        user1.getRoles().add(roleUser);

        UserDAOImpl userDAOImpl = new UserDAOImpl();
//        userDAOImpl.saveUser(user1);

        //update them role Staff cho user1
        RoleEntity roleStaff = new RoleEntity();
        roleStaff.setId(3);
        roleStaff.setName("Staff");

        user1.getRoles().add(roleStaff);
        userDAOImpl.updateUser(user1);

        RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
        roleUser.setName("UserUpdate");
        roleDAOImpl.updateRole(roleUser);

        roleDAOImpl.updateRole(roleUser);

        //cascade role-permission
        PermissionEntity permissionRead = new PermissionEntity();
        permissionRead.setId(1);
        permissionRead.setPermission("Read");

        PermissionEntity permissionWrite = new PermissionEntity();
        permissionWrite.setId(2);
        permissionWrite.setPermission("Write");

        PermissionEntity permissionDelete = new PermissionEntity();
        permissionDelete.setId(3);
        permissionDelete.setPermission("Delete");

        roleAdmin.getPermissions().add(permissionRead);
        roleAdmin.getPermissions().add(permissionWrite);
        roleAdmin.getPermissions().add(permissionDelete);

        roleDAOImpl.updateRole(roleAdmin);

        userDAOImpl.saveUser(user2);

        //Tạo thêm 1 user2 có role staff -> có permission read write
        user2.getRoles().add(roleStaff);
        userDAOImpl.updateUser(user2);

        roleStaff.getPermissions().add(permissionRead);
        roleStaff.getPermissions().add(permissionWrite);

        roleDAOImpl.updateRole(roleStaff);

        //update staff chỉ có thể write (xóa quyền Read)
        roleStaff.getPermissions().remove(permissionRead);
        roleDAOImpl.updateRole(roleStaff);

        //đổi tên write thành writeupdate
        PermissionImpl permissionImpl = new PermissionImpl();
        permissionWrite.setPermission("WriteUPDATE");
        permissionImpl.updatePermission(permissionWrite);


        System.out.println("thong tin user1: " + user1);
        System.out.println("thong tin user2: " + user2);

        //criteria - tìm user theo tên
        List<UserEntity> userList = userDAOImpl.getUserByName("va");
        System.out.println("cac user co chu 'va' trong ten:");
        for(UserEntity user : userList) {
            System.out.println(user);
        }

        //criteria - tìm user theo tên và role
        List<UserEntity> listUserNameRole = userDAOImpl.getUserByNameAndRole("nG","aD");
        System.out.println("cac user co chu 'nG' trong ten va role co chu 'aD': ");
        for(UserEntity user : listUserNameRole) {
            System.out.println(user);
        }
    }
}