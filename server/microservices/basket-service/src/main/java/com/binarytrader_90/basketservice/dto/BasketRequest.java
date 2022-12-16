package com.binarytrader_90.basketservice.dto;

import com.binarytrader_90.basketservice.model.BasketItem;

import java.util.List;

public class BasketRequest {

    private String username;
    private List<BasketItemRequest> items;
}
