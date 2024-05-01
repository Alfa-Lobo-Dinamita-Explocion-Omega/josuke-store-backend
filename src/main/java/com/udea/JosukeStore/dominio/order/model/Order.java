package com.udea.JosukeStore.dominio.order.model;


import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.dominio.user.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private State state;

    @Column(nullable = false)
    private User client;

    @Column(nullable = false)
    private List<Product> products;

    @Column(nullable = false)
    private Double price;

    public Order(State state, User client, List<Product> products, Double price) {
        this.state = state;
        this.client = client;
        this.products = products;
        this.price = price;
    }
}
