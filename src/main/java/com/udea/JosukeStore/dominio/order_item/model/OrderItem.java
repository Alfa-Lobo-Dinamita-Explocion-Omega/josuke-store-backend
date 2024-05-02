package com.udea.JosukeStore.dominio.order_item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.product.model.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "order_id")
    private Order order;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    @Column(name = "total_cost")
    private Long totalCost = 0L;

    public void calculateTotalCost() {
        if (product != null && quantity != null) {
            this.totalCost = (product.getPrice() * quantity);
        }
    }
}
