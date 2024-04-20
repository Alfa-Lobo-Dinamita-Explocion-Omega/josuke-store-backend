package com.udea.josukestore.dominio.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateData(
        @NotNull Long id,
        @NotBlank String productCode,
        @NotBlank String productName,
        @NotBlank String productDescription,
        @NotNull Long price,
        @NotNull Boolean isAvailable,
        @NotBlank String urlProductImage) {
}
