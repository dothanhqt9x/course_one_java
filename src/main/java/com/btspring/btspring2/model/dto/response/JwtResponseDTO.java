package com.btspring.btspring2.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponseDTO {
    private int userId;
    private String username;
    private String role;
}
