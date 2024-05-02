package com.udea.JosukeStore.dominio.order.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    ORDEN,
    PREPARACION,
    TERMINADO;
}
