package com.example.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateUtil {

    private static SessionFactory sessionFactory ;
    private static final Logger logger = Logger.getLogger(HibernateUtil.class.getName());

    private static SessionFactory buildSessionFactory() {
        try {
            logger.log(Level.INFO, "Tao SessionFactory thanh cong");
            return new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            logger.log(Level.SEVERE, "Tao SessionFactory that bai", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null || sessionFactory.isClosed()) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if(sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

}
