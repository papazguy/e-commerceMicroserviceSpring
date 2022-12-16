package com.binarytrader_90.basketservice.model;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem implements Serializable {

    private int quantity;
    public BigDecimal price;

    //product details
    private String productId;
    private String name;
    private String type;
    private String brand;
    private String description;
}
