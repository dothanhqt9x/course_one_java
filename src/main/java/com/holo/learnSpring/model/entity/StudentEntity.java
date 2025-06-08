package com.holo.learnSpring.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentEntity {

    @EmbeddedId
    StudentKey studentKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Student_Room",
            joinColumns = {
                    @JoinColumn(name = "student_id"),
                    @JoinColumn(name = "student_code")
            },
            inverseJoinColumns = @JoinColumn(name = "roomid")

    )
    private Set<RoomEntity> rooms;
}
