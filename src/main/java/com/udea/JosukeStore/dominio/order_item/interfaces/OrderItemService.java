package com.udea.JosukeStore.dominio.order_item.interfaces;

import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;

public interface OrderItemService {

    Long registerOrderItem(Order order, OrderItemRegistrationData item);


    
}
