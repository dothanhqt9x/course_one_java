package com.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionEntity {

    @Id
    private int id;
    @Column(name = "permission", nullable = false)
    private String permission;

    @ManyToMany(mappedBy = "permissions")
    private Set<RoleEntity> roles;
}
