package com.udea.JosukeStore.dominio.order.dto;


import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order.model.State;
import com.udea.JosukeStore.dominio.product.model.Product;
import com.udea.JosukeStore.dominio.user.model.User;

import java.util.List;

public record OrderData(
        int id,
        State state,
        User clientName,
        List<Product> products,
        Double price
) {
    public OrderData(Order order) {
        this(
                order.getId(),
                order.getState(),
                order.getClient(),
                order.getProducts(),
                order.getPrice()
        );
    }
}
