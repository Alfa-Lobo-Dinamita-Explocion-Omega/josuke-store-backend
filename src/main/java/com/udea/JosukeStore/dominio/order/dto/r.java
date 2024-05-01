package com.udea.JosukeStore.dominio.order.dto;

import com.udea.JosukeStore.dominio.product.dto.ProductData;

import java.util.List;

public record r(
        int id,
        String state,
        String clientName,
        List<ProductData> products,
        Double price
) {

}
