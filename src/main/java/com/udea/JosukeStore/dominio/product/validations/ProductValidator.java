package com.udea.JosukeStore.dominio.product.validations;

import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;

public interface ProductValidator {

    public void validate(ProductRegistrationData product);

    public void validate(ProductUpdateData product);
}
