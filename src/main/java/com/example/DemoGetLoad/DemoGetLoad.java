package com.example.DemoGetLoad;

import com.example.entity.RoleEntity;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DemoGetLoad {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            //get - find

            RoleEntity role1 = session.find(RoleEntity.class, 1);
            if (role1 != null) {
                System.out.println("Find- Tim thay role1: ");
                System.out.println(role1);
            } else {
                System.out.println("Find - ko tim thay role1");
            }

            //load
            RoleEntity role2 = session.byId(RoleEntity.class).load(1);
            System.out.println("LOAD Proxy : " + role2.getClass());
            if (role2 != null) {
                System.out.println("Load - Tim thay role2: ");
                System.out.println(role2);
            } else {
                System.out.println("Load - ko tim thay role2");
            }
            session.getTransaction().commit();
        }
    }
}
