package com.thai.spring_mvc.model;

import com.thai.spring_mvc.validation.NameConstraint;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NameConstraint
    private String name;

    @NotNull(message = "Gender không được để trống")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Birthdate không được để trống")
    @Past(message = "Birthdate phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @NotBlank(message = "Address không được để trống")
    private String address;

}
