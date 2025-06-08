package com.example.dao.impl;

import com.example.criteria.FindByUserAndRole;
import com.example.criteria.GetUserByName;
import com.example.dao.UserDAO;
import com.example.entity.UserEntity;
import com.example.entity.UserKey;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public void saveUser(UserEntity userEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(userEntity);
            logger.info("Luu user vao DB thanh cong");

            session.getTransaction().commit();
        }catch (Exception e) {
            logger.severe("Luu user vao DB that bai");
            e.printStackTrace();
        }
    }

    @Override
    public List<UserEntity> getAllUser() {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       List<UserEntity> userEntities = new ArrayList<>();
       try(Session session = sessionFactory.openSession()) {

           Query query = session.createQuery("from UserEntity");
           userEntities = query.getResultList();
           logger.info("Lay danh sach user thanh cong");

       }catch (Exception e) {
           logger.severe("Lay danh sach user that bai");
           e.printStackTrace();
       }
        return userEntities;
    }

    @Override
    public UserEntity getUserById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            UserEntity userEntity = session.find(UserEntity.class, id);
            logger.info("Lay user thanh cong");
            return userEntity;

        }catch (Exception e) {
            logger.severe("Lay user that bai");
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void updateUser(UserEntity userEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.merge(userEntity);
            logger.info("update user thanh cong");

            session.getTransaction().commit();

        }catch (Exception e) {
            logger.severe("update user that bai");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(UserKey userKey) {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       try(Session session = sessionFactory.openSession()) {
           session.beginTransaction();

           UserEntity userEntity = session.find(UserEntity.class, userKey);
           if(userEntity != null) {
               session.remove(userEntity);
               session.getTransaction().commit();
               logger.info("delete user thanh cong");
           }else{
               logger.info("ko tim thay user");
           }
       }catch (Exception e) {
           logger.severe("delete user that bai");
           e.printStackTrace();
       }
    }

    @Override
    public List<UserEntity> getUserByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            return GetUserByName.getUserByName(session, name);
        }
    }

    @Override
    public List<UserEntity> getUserByNameAndRole(String name, String role) {
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       try(Session session = sessionFactory.openSession()) {
           return FindByUserAndRole.findByUserAndRole(session, name, role);
       }
    }
}
