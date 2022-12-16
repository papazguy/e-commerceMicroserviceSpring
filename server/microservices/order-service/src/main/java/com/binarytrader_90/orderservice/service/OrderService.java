package com.binarytrader_90.orderservice.service;

import com.binarytrader_90.orderservice.dto.OrderItemDto;
import com.binarytrader_90.orderservice.dto.OrderRequest;
import com.binarytrader_90.orderservice.model.Order;
import com.binarytrader_90.orderservice.model.OrderItem;
import com.binarytrader_90.orderservice.model.aggregate.OrderStatus;
import com.binarytrader_90.orderservice.model.aggregate.ProductItemOrdered;
import com.binarytrader_90.orderservice.model.aggregate.ShippingAddress;
import com.binarytrader_90.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setSubTotal(orderRequest.getDeliveryFee()
                .add(orderRequest.getTotalPrice()));
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItem> orderLineItems = orderRequest.getOrderedItems()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderItems(orderLineItems);
        order.setUserName(orderRequest.getUserName());
        order.setDeliveryFee(orderRequest.getDeliveryFee());
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setOrderDate(Instant.now());
        orderRepository.save(order);
    }

    private OrderItem mapToDto(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setQuantity(orderItemDto.getQuantity());

        ProductItemOrdered productItemOrdered = new ProductItemOrdered();
        productItemOrdered.setName(orderItemDto.getName());
        productItemOrdered.setBrand(orderItemDto.getBrand());
        productItemOrdered.setPictureUrl(orderItemDto.getPictureUrl());
        productItemOrdered.setProductId(orderItemDto.getProductId());

        orderItem.setItemOrdered(productItemOrdered);
        return orderItem;
    }
}