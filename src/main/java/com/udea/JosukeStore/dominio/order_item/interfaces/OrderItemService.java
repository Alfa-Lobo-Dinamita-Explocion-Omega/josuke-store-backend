package com.udea.JosukeStore.dominio.order_item.interfaces;

import java.util.List;

import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;
import com.udea.JosukeStore.dominio.order_item.model.OrderItem;

public interface OrderItemService {

    Long registerOrderItem(Order order, OrderItemRegistrationData item);

    List<OrderItem> getOrderItems(Long id);


    
}
