package com.udea.JosukeStore.dominio.order;

import com.udea.JosukeStore.dominio.order.dto.BasicOrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderData;
import com.udea.JosukeStore.dominio.order.dto.OrderRegistrationData;
import com.udea.JosukeStore.dominio.order.interfaces.OrderService;
import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order.model.OrderStatus;
import com.udea.JosukeStore.dominio.order_item.dto.BasicOrderItemData;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;
import com.udea.JosukeStore.dominio.order_item.interfaces.OrderItemService;
import com.udea.JosukeStore.dominio.user.dto.BasicUserData;
import com.udea.JosukeStore.dominio.user.interfaces.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemService orderItemService;
    private UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemService orderItemService, UserService userService) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
        this.userService = userService;
    }

    @Override
    public BasicOrderData registerOrder(OrderRegistrationData orderRegistrationData) {
        Order order = new Order(orderRegistrationData.customerId(), orderRegistrationData.status());
        System.out.println("" + order.getId());
        order = this.orderRepository.save(order);

        Long totalCost = 0L;
        for (OrderItemRegistrationData item : orderRegistrationData.items()) {
            totalCost += this.orderItemService.registerOrderItem(order, item);
        }

        order.setTotalCost(totalCost);
        this.orderRepository.save(order);

        return new BasicOrderData(order);
    }

    @Override
    public List<OrderData> getOrdersForToday() {
        List<Order> orders = this.orderRepository.findByOrderDate(LocalDate.now());
        List<OrderData> ordersData = new ArrayList<>(); 
        for (Order order : orders) {
            BasicUserData customer = this.userService.getUserData(order.getCustomerId());
            List<BasicOrderItemData> orderItems = this.orderItemService.getBasicOrderItemsData(order.getId());
            ordersData.add(new OrderData(order, customer, orderItems));
        }
        
        return ordersData;    
    }

    @Override
    public List<OrderData> updateOrderStatus(Long id, OrderStatus status) {
        Order order = this.orderRepository.getReferenceById(id);
        order.setStatus(status);
        this.orderRepository.save(order);
        return getOrdersForToday();
    }

}
