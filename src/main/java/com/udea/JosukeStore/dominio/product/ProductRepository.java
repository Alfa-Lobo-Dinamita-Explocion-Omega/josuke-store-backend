package com.udea.JosukeStore.dominio.product;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.dominio.product.validations.ProductValidator;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByProductCode(String productCode);

    boolean existsByProductName(String productName);

    Product findByProductName(String productName);

    Product findByProductCode(String productCode);

    @Query("""
            SELECT P FROM Product P
            WHERE LOWER(P.productCode) LIKE LOWER(CONCAT('%', :term, '%'))
            OR LOWER(P.productName) LIKE LOWER(CONCAT('%', :term, '%'))
            """)
    List<Product> searchProductsByTerm(String term);

}
