package com.udea.JosukeStore.dominio.product;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.interfaces.ProductService;
import com.udea.JosukeStore.dominio.product.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductData registerProduct(ProductRegistrationData productRegistrationData) {
        Product product = (new Product.ProductBuilder(
                productRegistrationData.productCode(),
                productRegistrationData.productName(),
                productRegistrationData.productDescription(),
                productRegistrationData.price(),
                productRegistrationData.isAvailable())
                .setUrlProductImage(productRegistrationData.base64Image())
                .build());
        product = this.productRepository.save(product);
        return new ProductData(product);
    }

    @Override
    public ProductData getProductById(Long id) {
        return new ProductData(this.productRepository.getReferenceById(id));
    }

}
