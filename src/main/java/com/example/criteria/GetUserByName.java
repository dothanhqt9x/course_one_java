package com.example.criteria;

import com.example.entity.UserEntity;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class GetUserByName {

    public static List<UserEntity> getUserByName(Session session, String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.select(root);

        String lowerName = name.toLowerCase();
        criteria.where(builder.like(builder.lower(root.get("name")), "%" + lowerName + "%"));


        Query query = session.createQuery(criteria);
        List<UserEntity> users = query.getResultList();
        return users;
    }
}
