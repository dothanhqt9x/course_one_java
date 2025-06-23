package com.btspring.btspring2.model.dto.response;

import com.btspring.btspring2.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoughtProductResponseDTO {
    private ProductEntity product;
    private int quantity;

}
