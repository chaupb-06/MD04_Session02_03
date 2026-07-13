package com.example.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String sku;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String producer;
    @Column(name = "import_price", nullable = false, columnDefinition = "numeric(10,2) default 0.00")
    @Builder.Default
    private Double importPrice = 0.00;
    @Column(name = "sell_price", nullable = false, columnDefinition = "numeric(10,2) default 0.00")
    @Builder.Default
    private Double sellPrice = 0.00;
    @Column(nullable = false)
    @Builder.Default
    private Integer stock = 0;
}
