package com.udea.JosukeStore.dominio.order.interfaces;

import com.udea.JosukeStore.dominio.order.dto.OrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderRegistrationData;

import jakarta.validation.Valid;

public interface OrderService {

    OrderData registerOrder(@Valid OrderRegistrationData orderRegistrationData);
    
}
