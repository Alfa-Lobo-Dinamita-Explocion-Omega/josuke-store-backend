package com.udea.JosukeStore.dominio.product.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;

public interface ProductService {

    ProductData registerProduct(ProductRegistrationData productRegistrationData);

    ProductData getProductById(Long id);

    ProductData updateProduct(ProductUpdateData productUpdateData);

    List<ProductData> getProducts();

    List<ProductData> getProductsByTerm(String term);

    Page<ProductData> getAvailableProducts(Pageable pagination);

    


}
