package com.binarytrader_90.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    //product details
    private String productId;
    private String name;
    private String pictureUrl;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
}
