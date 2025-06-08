package com.example.cache;

import com.example.entity.UserEntity;
import com.example.entity.UserKey;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CacheLevel1 {
    private static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            UserKey userKey = new UserKey();
            userKey.setId(1);
            userKey.setCode("nva");

            log.log(Level.INFO, "Lan 1 - lay user tu DB: ");
            UserEntity user1 = session.find(UserEntity.class, userKey);
            if(user1 != null) {
                System.out.println(user1);
            }else{
                log.log(Level.INFO, "user ko ton tai!");
            }

            log.log(Level.INFO, "Lan 2 - lay user tu Cache: ");
            UserEntity user2 = session.find(UserEntity.class, userKey);
            if(user2 != null) {
                System.out.println(user2);
            }else{
                log.log(Level.INFO, "user ko ton tai!");
            }

            //kiem tra user1 == user2 ?
            if(user1 == user2) {
                log.log(Level.INFO, "user1 == user2");
            }
            else{
                log.log(Level.INFO, "user1 khac user2");
            }
            session.getTransaction().commit();
        }
    }
}
