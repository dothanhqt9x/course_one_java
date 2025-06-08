package com.example.criteria;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class FindByUserAndRole {
    public static List<UserEntity> findByUserAndRole(Session session, String name, String role) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);

        Join<UserEntity, RoleEntity> roles = root.join("roles");

        String lowerName = name.toLowerCase();
        String lowerRole = role.toLowerCase();

        criteria.select(root).where(builder.and(
                builder.like(builder.lower(root.get("name")), "%" + lowerName + "%"),
                builder.like(builder.lower(roles.get("name")), "%" + lowerRole + "%")
        ));

        Query query = session.createQuery(criteria);
        List<UserEntity> users = query.getResultList();
        return users;
    }
}
