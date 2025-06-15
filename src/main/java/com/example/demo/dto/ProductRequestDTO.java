package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRequestDTO {
    @NotNull(message = "name không được để trống")
    @Size(max = 4, message = "name không được vượt quá {max} ký tự")
    private String name;

    @NotNull(message = "price không được để trống")
    @Positive(message = "price phải là một số dương")
    private Double price;
}
