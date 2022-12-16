package com.binarytrader_90.orderservice.dto;

import com.binarytrader_90.orderservice.model.aggregate.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public String userName;
    public List<OrderItemDto> orderedItems;
    public ShippingAddress shippingAddress;
    public Integer totalCartItems;
    public BigDecimal totalPrice;
    public BigDecimal deliveryFee;
}
