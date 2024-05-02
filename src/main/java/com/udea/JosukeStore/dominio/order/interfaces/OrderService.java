package com.udea.JosukeStore.dominio.order.interfaces;

import java.util.List;

import com.udea.JosukeStore.dominio.order.dto.BasicOrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderRegistrationData;

import jakarta.validation.Valid;

public interface OrderService {

    BasicOrderData registerOrder(@Valid OrderRegistrationData orderRegistrationData);

    List<OrderData> getOrdersForToday();
    
}
