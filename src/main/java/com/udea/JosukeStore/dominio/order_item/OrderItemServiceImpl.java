package com.udea.JosukeStore.dominio.order_item;

import org.springframework.stereotype.Service;

import com.udea.JosukeStore.dominio.order.model.Order;
import com.udea.JosukeStore.dominio.order_item.dto.OrderItemRegistrationData;
import com.udea.JosukeStore.dominio.order_item.interfaces.OrderItemService;
import com.udea.JosukeStore.dominio.order_item.model.OrderItem;
import com.udea.JosukeStore.dominio.product.interfaces.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;
    private ProductService productService;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, ProductService productService){
        this.orderItemRepository = orderItemRepository; 
        this.productService = productService; 
    }

    @Override
    public Long registerOrderItem(Order order, OrderItemRegistrationData item) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(item.quantity());
        orderItem.setProduct(this.productService.getProduct(item.productId()));
        orderItem.calculateTotalCost();
        orderItem = this.orderItemRepository.save(orderItem);

        return orderItem.getTotalCost();
    }
}
