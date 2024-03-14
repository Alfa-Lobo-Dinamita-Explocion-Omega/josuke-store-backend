package com.udea.JosukeStore.dominio.product.interfaces;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;

public interface ProductService {

    ProductData registerProduct(ProductRegistrationData productRegistrationData);

    ProductData getProductById(Long id);

    ProductData updateProduct(ProductUpdateData productUpdateData);


}
