package com.udea.JosukeStore.dominio.order.dto;



import java.util.List;

import com.udea.JosukeStore.dominio.order.model.OrderStatus;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;

public record OrderRegistrationData(
    Long customerId,
    OrderStatus status,
    List<OrderItemRegistrationData> items
)
{

}
