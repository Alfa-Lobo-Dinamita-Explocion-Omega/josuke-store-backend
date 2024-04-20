package com.udea.JosukeStore.dominio.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "product_code")
    private String productCode;

    @Column(unique = true, nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "product_description")
    private String productDescription;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, name = "is_available")
    private Boolean isAvailable;

    @Column(nullable = false, name = "url_product_image")
    private String urlProductImage;


    public Product(String code, String name, String description, Long price, Boolean isAvailable, String urlProductImage) {
        this.productCode = code;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.urlProductImage = urlProductImage;
    }

    public Product(){};


}
