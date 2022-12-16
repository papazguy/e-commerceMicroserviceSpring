package com.binarytrader_90.basketservice.service;


import com.binarytrader_90.basketservice.model.Basket;
import com.binarytrader_90.basketservice.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    public Basket getBasket(String username) {
         return basketRepository.getBasketForUser(username);
    }

    public Basket updateBasket(Basket basketRequest) {
        return basketRepository.updateBasket(basketRequest);
    }

    public  Basket deleteBasket(String username) {
         basketRepository.deleteBasket(username);
         return getBasket(username);
    }
}
