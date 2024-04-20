package com.udea.JosukeStore.dominio.product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udea.JosukeStore.dominio.product.dto.ProductData;
import com.udea.JosukeStore.dominio.product.model.Product;

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

    List<Product> findByIsAvailable(Boolean isAvailable);

    @Query("""
        SELECT new com.udea.JosukeStore.dominio.product.dto.ProductData(p.id, p.productCode, p.productName, p.productDescription, p.price, p.isAvailable, p.urlProductImage) 
        FROM Product p WHERE p.isAvailable = true 
        """)
    Page<ProductData> findByIsAvailableTrue(Pageable pagination);


}
