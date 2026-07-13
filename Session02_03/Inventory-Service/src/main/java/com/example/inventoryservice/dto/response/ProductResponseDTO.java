package com.example.inventoryservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponseDTO {
    private String sku;
    private String productName;
    private String producer;
    private Double sellPrice;
    private Integer stockQuantity;
}
