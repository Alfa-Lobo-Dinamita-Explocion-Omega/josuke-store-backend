package com.udea.JosukeStore.dominio.product.dto;

import com.udea.JosukeStore.dominio.product.model.Product;

public record ProductData(
    Long id
) {

    public ProductData(Product product){
        this(
            product.getId()
        );
    }
}
