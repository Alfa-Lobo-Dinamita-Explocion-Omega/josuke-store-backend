package com.udea.JosukeStore.dominio.product;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;
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
        Product product = new Product(
                productRegistrationData.productCode(),
                productRegistrationData.productName(),
                productRegistrationData.productDescription(),
                productRegistrationData.price(),
                productRegistrationData.isAvailable(),
                productRegistrationData.urlProductImage());
        product = this.productRepository.save(product);
        return new ProductData(product);
    }

    @Override
    public ProductData getProductById(Long id) {
        return new ProductData(this.productRepository.getReferenceById(id));
    }

    @Override
    public ProductData updateProduct(ProductUpdateData productUpdateData) {

        if (this.productRepository.existsById(productUpdateData.id())) {
            Product product = this.productRepository.getReferenceById(productUpdateData.id());
            product.setProducCode(productUpdateData.productCode());
            product.setProductName(productUpdateData.productName());
            product.setProductDescription(productUpdateData.productDescription());
            product.setPrice(productUpdateData.price());
            product.setIsAvailable(productUpdateData.isAvailable());
            product.setUrlProductImage(productUpdateData.urlProductImage());

            product = this.productRepository.save(product);
            return new ProductData(product);
            
        } else {
            throw new RuntimeException("Producto no encontrado");
        }

    }

}
