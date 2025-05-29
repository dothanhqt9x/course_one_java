package com.example;

import com.example.entity.UserEntity;
import com.example.entity.UserKey;
import com.example.utils.BCriptUtil;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(userEntity);
            session.persist(userEntity2);
            logger.info("Luu user vao DB thanh cong");

            session.getTransaction().commit();
        }catch (Exception e) {
            logger.severe("Luu user vao DB that bai");
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSessionFactory();
        }


    }
}