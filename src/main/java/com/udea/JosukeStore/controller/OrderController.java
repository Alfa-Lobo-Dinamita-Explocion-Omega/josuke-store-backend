package com.udea.JosukeStore.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udea.JosukeStore.dominio.order.dto.*;
import com.udea.JosukeStore.dominio.order.interfaces.OrderService;
import com.udea.JosukeStore.dominio.order.model.OrderStatus;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<BasicOrderData> registerOrder(
            @RequestBody @Valid OrderRegistrationData orderRegistrationData) {
        BasicOrderData basicOrderData = this.orderService.registerOrder(orderRegistrationData);
        return ResponseEntity.ok().body(basicOrderData);
    }

    @GetMapping()
    public ResponseEntity<List<OrderData>> getOrdersForToday() {
        return ResponseEntity.ok().body(this.orderService.getOrdersForToday());
    }


    @PatchMapping()
    public ResponseEntity<List<OrderData>> updateOrderStatus(@RequestParam("id") Long id, @RequestParam("status") OrderStatus status){
        return ResponseEntity.ok().body(this.orderService.updateOrderStatus(id, status));
    }

}
