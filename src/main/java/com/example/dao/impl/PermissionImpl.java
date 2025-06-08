package com.example.dao.impl;

import com.example.dao.PermissionDAO;
import com.example.entity.PermissionEntity;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Level;
import java.util.logging.Logger;


public class PermissionImpl implements PermissionDAO {
    private final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void updatePermission(PermissionEntity permission) {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

       try (Session session = sessionFactory.openSession()) {
           session.beginTransaction();
           PermissionEntity permissionEntity = new PermissionEntity();
           permissionEntity.setId(permission.getId());
           permissionEntity.setPermission(permission.getPermission());

           session.merge(permissionEntity);
           session.getTransaction().commit();
           log.log(Level.INFO, "update permission successful");
       }catch (Exception e) {
          log.log(Level.SEVERE, "Update permission failed", e);
       }
    }
}
