package com.udea.JosukeStore.dominio.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.JosukeStore.dominio.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
