package com.binarytrader_90.orderservice.repository;

import com.binarytrader_90.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
