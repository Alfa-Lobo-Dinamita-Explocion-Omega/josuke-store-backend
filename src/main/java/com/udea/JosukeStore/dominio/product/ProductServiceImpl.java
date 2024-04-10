package com.udea.JosukeStore.dominio.product;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.dto.ProductRegistrationData;
import com.udea.JosukeStore.dominio.product.dto.ProductUpdateData;
import com.udea.JosukeStore.dominio.product.interfaces.ProductService;
import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.dominio.product.validations.*;
import com.udea.JosukeStore.infra.exceptions.CustomValidationException;
import com.udea.JosukeStore.infra.exceptions.DataIntegrityValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private List<ProductValidator> validators;

    public ProductServiceImpl(ProductRepository productRepository, List<ProductValidator> validators) {
        this.productRepository = productRepository;
        this.validators = validators;
    }

    @Override
    public ProductData registerProduct(ProductRegistrationData productRegistrationData) {
        List<CustomValidationException> exceptions = new ArrayList<>();
        validators.forEach(v -> {
            try {
                v.validate(productRegistrationData);
            } catch (CustomValidationException e) {
                exceptions.add(e);
            }
        });
        if (!exceptions.isEmpty()) {
            throw new DataIntegrityValidationException(exceptions);
        }

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
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent()){
            return new ProductData(product.get());
        }else {
            throw new CustomValidationException("id",
                    "product with id (" + id + ") does not exist!");
        }
    }

    @Override
    public ProductData updateProduct(ProductUpdateData productUpdateData) {

        if (this.productRepository.existsById(productUpdateData.id())) {
            List<CustomValidationException> exceptions = new ArrayList<>();
            validators.forEach(v -> {
                try {
                    v.validate(productUpdateData);
                } catch (CustomValidationException e) {
                    exceptions.add(e);
                }
            });
            if (!exceptions.isEmpty()) {
                throw new DataIntegrityValidationException(exceptions);
            }

            Product product = this.productRepository.getReferenceById(productUpdateData.id());
            product.setProductCode(productUpdateData.productCode());
            product.setProductName(productUpdateData.productName());
            product.setProductDescription(productUpdateData.productDescription());
            product.setPrice(productUpdateData.price());
            product.setIsAvailable(productUpdateData.isAvailable());
            product.setUrlProductImage(productUpdateData.urlProductImage());

            product = this.productRepository.save(product);
            return new ProductData(product);

        } else {
            throw new CustomValidationException("Product",
                    "product with id (" + productUpdateData.id() + ") does not exist!");
        }

    }

    @Override
    public List<ProductData> getProducts() {
      return this.productRepository.findAll().stream().map(ProductData::new).toList();
    }

    
    @Override
    public List<ProductData> getProductsByTerm(String term) {
        return this.productRepository.searchProductsByTerm(term).stream().map(ProductData::new).toList();
    }

    @Override
    public Page<ProductData> getAvailableProducts(Pageable pagination) {
        return this.productRepository.findByIsAvailableTrue(pagination);    
    }




}
