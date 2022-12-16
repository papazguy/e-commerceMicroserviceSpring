package com.binarytrader_90.orderservice.model;


import com.binarytrader_90.orderservice.model.aggregate.OrderStatus;
import com.binarytrader_90.orderservice.model.aggregate.ShippingAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    private String userName;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "addressLine1", column = @Column(name = "street")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "apartment _number"))
    })
    private ShippingAddress shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private Instant orderDate = Instant.now();


    private BigDecimal totalPrice;
    private BigDecimal deliveryFee;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal subTotal;



}
