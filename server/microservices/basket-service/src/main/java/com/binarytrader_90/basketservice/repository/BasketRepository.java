package com.binarytrader_90.basketservice.repository;

import com.binarytrader_90.basketservice.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class BasketRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "BASKET";

    public boolean addBasket(Basket basket){
        try{
            redisTemplate.opsForHash().put(KEY, basket.getUserName(), basket);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;

        }
    }

    public Basket getBasketForUser(String username){
        Basket basket = null;
        try{
            basket = (Basket) redisTemplate.opsForHash().get(KEY, username);
        } catch(Exception e){
            e.printStackTrace();
        }
        return basket;
    }

    public Basket updateBasket(Basket basket) {
        try{
            redisTemplate.opsForHash().put(KEY, basket.getUserName(), basket);
        } catch(Exception e){
            e.printStackTrace();
        }
        return getBasketForUser(basket.getUserName());
    }

    public void deleteBasket(String username){
        try{
            redisTemplate.opsForHash().delete(KEY, username);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
