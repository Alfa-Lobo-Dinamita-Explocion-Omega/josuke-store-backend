package com.udea.JosukeStore.dominio.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "product_code")
    private String ProducCode;

    @Column(unique = true, nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "product_description")
    private String productDescription;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false, name = "is_available")
    private Boolean isAvailable;

    @Column(nullable = false, name = "url_product_image")
    private String urlProductImage;
}

