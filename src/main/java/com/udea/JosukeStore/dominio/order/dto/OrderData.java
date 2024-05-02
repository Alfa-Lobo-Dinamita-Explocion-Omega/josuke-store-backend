package com.udea.JosukeStore.dominio.order.dto;

import java.time.LocalDate;

import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order.model.OrderStatus;

public record OrderData(
    Long id,
    Long customerId,
    OrderStatus status,
    Long totalCost,
    LocalDate orderDate
) {
    public OrderData(Order order){
        this(
            order.getId(),
            order.getCustomerId(),
            order.getStatus(),
            order.getTotalCost(),
            order.getOrderDate()
        );
    }
}
