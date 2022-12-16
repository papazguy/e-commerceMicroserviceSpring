package com.binarytrader_90.productservice.repository;

import com.binarytrader_90.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}