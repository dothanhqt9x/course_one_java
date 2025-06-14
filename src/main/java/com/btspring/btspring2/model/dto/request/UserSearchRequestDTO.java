package com.btspring.btspring2.model.dto.request;

import com.btspring.btspring2.model.entity.GenderEnum;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSearchRequestDTO {

    private Integer id;

    @Size(min = 6, message = "Tên tối thiểu 6 ký tự!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Tên không được chứa ký tự đặc biệt")
    private String name;

    private GenderEnum gender;

    private String address;
}
