package com.udea.JosukeStore.dominio.product.dto;

public record ProductRegistrationData(
        String productCode,
        String productName,
        String productDescription,
        Float price,
        Boolean isAvailable,
        String base64Image) {
}
