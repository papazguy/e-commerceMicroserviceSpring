package com.binarytrader_90.orderservice.model;

import com.binarytrader_90.orderservice.model.aggregate.ProductItemOrdered;
import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table(name = "t_order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProductItemOrdered itemOrdered;
    private BigDecimal price;
    private int quantity;

}
