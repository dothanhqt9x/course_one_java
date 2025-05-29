package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity {
    @Id
    private int id;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @ManyToOne
    private RoleEntity role;
}
