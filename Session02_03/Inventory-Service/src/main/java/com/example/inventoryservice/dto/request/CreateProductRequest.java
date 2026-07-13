package com.example.inventoryservice.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateProductRequest {
    @NotBlank(message = "Không được để trống mã sản phẩm!")
    private String sku;
    @NotBlank(message = "Không được để trống tên sản phẩm!")
    private String productName;
    @NotBlank(message = "Không được để trống nhà sản xuất!")
    private String producer;
    @NotNull(message = "Không được để trống giá nhập!")
    @Min(value = 0, message = "Giá nhập không được âm!")
    private Double importPrice;
    @NotNull(message = "Không được để trống giá xuất!")
    @Min(value = 0, message = "Giá bán không được âm!")
    private Double sellPrice;
    @NotNull(message = "Không được để trống số lượng tồn kho!")
    @Min(value = 0, message = "Số lượng tồn kho không được âm!")
    private Integer stockQuantity;
}
