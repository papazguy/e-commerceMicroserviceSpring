package com.binarytrader_90.basketservice.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Basket implements Serializable {
    //username has to be unique or use an autogeneratedId
    private String userName;
    private List<BasketItem> items = new ArrayList<>();


   public BigDecimal getTotalPrice(){
        double totalPrice = items.stream()
                .map(item -> item.getPrice().doubleValue() *  (double)item.getQuantity())
                .reduce(0.0, Double::sum);
        return BigDecimal.valueOf(totalPrice);
    }

    public Integer getTotalCartItems(){
       return items.size();
    }
}
