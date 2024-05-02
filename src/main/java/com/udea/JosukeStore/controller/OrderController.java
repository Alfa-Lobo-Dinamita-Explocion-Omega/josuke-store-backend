package com.udea.JosukeStore.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.JosukeStore.dominio.order.dto.*;
import com.udea.JosukeStore.dominio.order.interfaces.OrderService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseEntity<OrderData>  registerOrder(@RequestBody @Valid OrderRegistrationData orderRegistrationData){
        OrderData orderData = this.orderService.registerOrder(orderRegistrationData);
        return ResponseEntity.ok().body(orderData);
    }
    


}
