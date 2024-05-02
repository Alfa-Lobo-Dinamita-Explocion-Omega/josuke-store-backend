package com.udea.JosukeStore.dominio.order_item.dto;

import com.udea.JosukeStore.dominio.order_item.model.OrderItem;

public record BasicOrderItemData(
    Long id,
    String productCode,
    String productName,
    String productDescription,
    Long unitPrice,
    Long quantity,
    Long cost
) {
    public BasicOrderItemData(OrderItem item){
        this(
            item.getId(),
            item.getProduct().getProductCode(),
            item.getProduct().getProductName(),
            item.getProduct().getProductDescription(),
            item.getProduct().getPrice(),
            item.getQuantity(),
            item.getTotalCost()
        );
    }
    
}
