package com.btspring.btspring2.model.dto.request;


import com.btspring.btspring2.model.entity.GenderEnum;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class UserRequestDTO {

    @Size(min = 6, message = "Tên tối thiểu 6 ký tự!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên không được chứa ký tự đặc biệt")
    private String name;

    private GenderEnum gender;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    private String address;

    private String username;

    private String password;

    private String role;

}
