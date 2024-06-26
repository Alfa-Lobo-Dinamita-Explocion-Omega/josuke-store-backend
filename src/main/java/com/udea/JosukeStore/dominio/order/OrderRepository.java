package com.udea.JosukeStore.dominio.order;

import com.udea.JosukeStore.dominio.order.model.Order;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderDate(LocalDate date);
}
