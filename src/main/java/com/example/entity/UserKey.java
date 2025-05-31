package com.example.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserKey implements Serializable {
    private int id;
    private String code;

    @Override
    public String toString() {
        return "UserKey{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
