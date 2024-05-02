package com.udea.JosukeStore.dominio.order.dto;

import java.time.LocalDate;
import java.util.List;

import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order.model.OrderStatus;
import com.udea.JosukeStore.dominio.order_item.model.OrderItem;
import com.udea.JosukeStore.dominio.user.dto.BasicUserData;

public record OrderData(
        Long id,
        OrderStatus status,
        Long totalCost,
        LocalDate orderDate,
        BasicUserData customer,
        List<OrderItem> orderItems) {
    public OrderData(Order order, BasicUserData customer, List<OrderItem> orderItems) {
        this(order.getId(),
                order.getStatus(),
                order.getTotalCost(),
                order.getOrderDate(),
                customer,
                orderItems);
    }

}
