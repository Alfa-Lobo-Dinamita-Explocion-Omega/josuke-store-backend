package com.udea.JosukeStore.dominio.order_item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.JosukeStore.dominio.order_item.model.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    List<OrderItem> findByOrder_Id(Long id);
}
