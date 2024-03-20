package com.udea.JosukeStore.dominio.product.validations;

import org.springframework.stereotype.Component;

import com.udea.JosukeStore.dominio.product.ProductRepository;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;
import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;

@Component
public class ProductNameValidation implements ProductValidator {

    private ProductRepository productRepository;

    public ProductNameValidation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(ProductRegistrationData product) {
        validateProductName(product.productName(), null);
    }

    @Override
    public void validate(ProductUpdateData product) {
        validateProductName(product.productName(), product.id());
    }

    private void validateProductName(String productName, Long productId) {
        Product existingProduct = this.productRepository.findByProductName(productName);
        if (existingProduct != null && (productId == null || !existingProduct.getId().equals(productId))) {
            throw new CustomValidationException("productName",
                    "The product name (" + productName + ") is already in use.");
        }
    }

}
