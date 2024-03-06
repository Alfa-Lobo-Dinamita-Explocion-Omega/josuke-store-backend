package com.udea.JosukeStore.dominio.product.interfaces;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;


public interface ProductService {

    ProductData registerProduct(ProductRegistrationData productRegistrationData);

    ProductData getProductById(Long id);
    
}
