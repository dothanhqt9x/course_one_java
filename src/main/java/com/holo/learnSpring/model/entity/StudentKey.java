package com.holo.learnSpring.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StudentKey implements Serializable {
    private Long id;
    private String code;
}
