package com.udea.josukestore.dominio.product.validations;

import com.udea.josukestore.dominio.product.dto.ProductRegistrationData;
import com.udea.josukestore.dominio.product.dto.ProductUpdateData;

public interface ProductValidator {

    public void validate(ProductRegistrationData product);

    public void validate(ProductUpdateData product);
}
