package com.udea.JosukeStore.dominio.product.dto;

import com.udea.JosukeStore.dominio.product.model.Product;


public record ProductData(
        Long id,
        String productCode,
        String productName,
        String productDescription,
        Long price,
        Boolean isAvailable,
        String urlProductImage) {

    public ProductData(Product product) {
        this(
                product.getId(),
                product.getProductCode(),
                product.getProductName(),
                product.getProductDescription(),
                product.getPrice(),
                product.getIsAvailable(),
                product.getUrlProductImage());
    }
}
