package com.udea.JosukeStore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.udea.JosukeStore.dominio.product.dto.*;
import com.udea.JosukeStore.dominio.product.interfaces.ProductService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductData> registerProduct(
            @RequestBody @Valid ProductRegistrationData productRegistrationData,
            UriComponentsBuilder uriComponentsBuilder) {
        ProductData productData = this.productService.registerProduct(productRegistrationData);
        URI uri = uriComponentsBuilder.path("products/{id}").buildAndExpand(productData.id()).toUri();
        return ResponseEntity.created(uri).body(productData);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductData> getProductById(@PathVariable Long id) {
        ProductData productData = this.productService.getProductById(id);
        return ResponseEntity.ok().body(productData);
    }

    @PutMapping("/products")
    public ResponseEntity<ProductData> updateProduct(@RequestBody @Valid ProductUpdateData productUpdateData) {
        return ResponseEntity.ok(this.productService.updateProduct(productUpdateData));
    }

    @GetMapping("/products/list")
    public ResponseEntity<List<ProductData>> getProducts() {
        return ResponseEntity.ok().body(this.productService.getProducts());
    }

    
    @GetMapping("/products")
    public ResponseEntity<List<ProductData>> getProductsByTerm(@RequestParam("term") String term) {
        return ResponseEntity.ok().body(this.productService.getProductsByTerm(term));
    }

    @GetMapping("/customer/products")
    public ResponseEntity<Page<ProductData>> getAvailableProducts(@PageableDefault(size = 8) Pageable pagination) {
        return ResponseEntity.ok().body(this.productService.getAvailableProducts(pagination));
    }

}
