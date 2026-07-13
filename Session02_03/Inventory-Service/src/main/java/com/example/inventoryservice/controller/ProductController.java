package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.request.CreateProductRequest;
import com.example.inventoryservice.dto.response.ApiResponse;
import com.example.inventoryservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllProducts() {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy danh sách sản phẩm thành công!",
                productService.findAll(),
                null,
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<?>> addProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tạo sản phẩm mới thành công!",
                productService.createProduct(createProductRequest),
                null,
                LocalDateTime.now()
        ), HttpStatus.CREATED);
    }
}
