package com.example.inventoryservice.service.Impl;

import com.example.inventoryservice.dto.request.CreateProductRequest;
import com.example.inventoryservice.dto.response.ProductResponseDTO;
import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import com.example.inventoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> ProductResponseDTO.builder()
                        .sku(product.getSku())
                        .productName(product.getName())
                        .producer(product.getProducer())
                        .sellPrice(product.getSellPrice())
                        .stockQuantity(product.getStock())
                        .build()
                ).toList();
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequest request) {
        if (productRepository.existsBySku(request.getSku())) {
            throw new IllegalArgumentException("sku already exists");
        }
        Product product = Product.builder()
                .sku(request.getSku())
                .name(request.getProductName())
                .producer(request.getProducer())
                .importPrice(request.getImportPrice())
                .sellPrice(request.getSellPrice())
                .stock(request.getStockQuantity())
                .build();
        productRepository.save(product);
        return ProductResponseDTO.builder()
                .sku(product.getSku())
                .productName(product.getName())
                .producer(product.getProducer())
                .sellPrice(product.getSellPrice())
                .stockQuantity(product.getStock())
                .build();
    }
}
