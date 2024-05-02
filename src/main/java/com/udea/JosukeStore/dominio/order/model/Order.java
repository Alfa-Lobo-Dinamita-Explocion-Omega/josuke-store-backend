package com.udea.JosukeStore.dominio.order.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "customer_id")
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "order_status")
    private OrderStatus status;

    @Column(nullable = false, name = "total_cost")
    private long totalCost;

    @Column(nullable = false, name = "order_date")
    private LocalDate orderDate;

    public Order(Long customerId, OrderStatus status) {
        this.customerId = customerId;
        this.status = status;
        this.orderDate = LocalDate.now();
        this.totalCost = 0L;
    }

    public Order(){}

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotalCost(Long totalCost){
        this.totalCost = totalCost;
    }


}
