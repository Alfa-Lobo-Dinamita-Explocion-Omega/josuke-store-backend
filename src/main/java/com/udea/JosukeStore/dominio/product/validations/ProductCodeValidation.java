package com.udea.JosukeStore.dominio.product.validations;

import org.springframework.stereotype.Component;

import com.udea.JosukeStore.dominio.product.ProductRepository;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;
import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;

@Component
public class ProductCodeValidation implements ProductValidator {

    private ProductRepository productRepository;

    public ProductCodeValidation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(ProductRegistrationData product) {
        validateProductCode(product.productCode(), null);
    }

    @Override
    public void validate(ProductUpdateData product) {
        validateProductCode(product.productCode(), product.id());
    }

    private void validateProductCode(String productCode, Long productId) {
        Product existingProduct = this.productRepository.findByProductCode(productCode);
        if (existingProduct != null && (productId == null || !existingProduct.getId().equals(productId))) {
            throw new CustomValidationException("productCode",
                    "The product code (" + productCode + ") is already in use.");
        }
    }

}
