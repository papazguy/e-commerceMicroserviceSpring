package com.binarytrader_90.basketservice.controller;

import com.binarytrader_90.basketservice.dto.ResponseBasket;
import com.binarytrader_90.basketservice.model.Basket;
import com.binarytrader_90.basketservice.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final BasketService basketService;


    @GetMapping(value = "/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Basket getBasket(@PathVariable String username){
        return basketService.getBasket(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Basket updateBasket(@RequestBody Basket basket){
        return basketService.updateBasket(basket);

    }

    @DeleteMapping(value="username")
    public Basket deleteBasket(String username){
        return basketService.deleteBasket(username);
    }



}
