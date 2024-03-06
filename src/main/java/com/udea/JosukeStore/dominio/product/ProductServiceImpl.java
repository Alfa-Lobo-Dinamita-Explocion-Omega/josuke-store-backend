package com.udea.JosukeStore.dominio.product;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.interfaces.ProductService;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductData registerProduct(ProductRegistrationData productRegistrationData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerProduct'");
    }

    @SuppressWarnings("null") // esto se debe cambiar (agregar manejadores para datos nulos)
    @Override
    public ProductData getProductById(Long id) {
        return new ProductData(this.productRepository.getReferenceById(id));
    }

    
}
