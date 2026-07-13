package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.request.CreateProductRequest;
import com.example.inventoryservice.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> findAll();
    ProductResponseDTO createProduct(CreateProductRequest request);
}
