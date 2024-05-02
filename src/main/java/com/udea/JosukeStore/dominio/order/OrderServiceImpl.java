package com.udea.JosukeStore.dominio.order;

import com.udea.JosukeStore.dominio.order.dto.OrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderRegistrationData;
import com.udea.JosukeStore.dominio.order.interfaces.OrderService;
import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;
import com.udea.JosukeStore.dominio.order_item.interfaces.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemService orderItemService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
    }

    @Override
    public OrderData registerOrder(OrderRegistrationData orderRegistrationData) {
        Order order = new Order(orderRegistrationData.customerId(), orderRegistrationData.status());
        System.out.println("" + order.getId());
        order = this.orderRepository.save(order);

        Long totalCost = 0L;
        for (OrderItemRegistrationData item : orderRegistrationData.items()) {
            totalCost += this.orderItemService.registerOrderItem(order, item);
        }

        order.setTotalCost(totalCost);
        this.orderRepository.save(order);

        return new OrderData(order);
    }

}
