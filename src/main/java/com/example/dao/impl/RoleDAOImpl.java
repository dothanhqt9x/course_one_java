package com.example.dao.impl;

import com.example.dao.RoleDAO;
import com.example.entity.RoleEntity;
import com.example.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RoleDAOImpl implements RoleDAO {
    private static final Logger logger = Logger.getLogger(RoleDAOImpl.class.getName());

    @Override
    public void saveRole(RoleEntity roleEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(roleEntity);
            logger.info("Luu role vao DB thanh cong");

            session.getTransaction().commit();
        }catch (Exception e) {
            logger.severe("Luu role vao DB that bai");
            e.printStackTrace();
        }
    }

    @Override
    public List<RoleEntity> getAllRole() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        List<RoleEntity> roleEntities = new ArrayList<>();
        try(Session session = sessionFactory.openSession()) {

            Query query = session.createQuery("from RoleEntity");
            roleEntities = query.getResultList();
            logger.info("Lay danh sach role thanh cong");

        }catch (Exception e) {
            logger.severe("Lay danh sach role that bai");
            e.printStackTrace();
        }

        return roleEntities;
    }

    @Override
    public RoleEntity getRoleById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            RoleEntity roleEntity = session.find(RoleEntity.class, id);
            logger.info("Lay role thanh cong");
            return roleEntity;

        }catch (Exception e) {
            logger.severe("Lay role that bai");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.merge(roleEntity);
            logger.info("update role thanh cong");

            session.getTransaction().commit();

        }catch (Exception e) {
            logger.severe("update role that bai");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            RoleEntity roleEntity = session.find(RoleEntity.class, id);
            if(roleEntity != null) {
                session.remove(roleEntity);
                session.getTransaction().commit();
                logger.info("delete role thanh cong");
            }else{
                logger.info("ko tim thay role");
            }
        }catch (Exception e) {
            logger.severe("delete role that bai");
            e.printStackTrace();
        }
    }
}
