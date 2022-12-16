package com.binarytrader_90.orderservice.model.aggregate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class ProductItemOrdered {
    private String productId;
    private String name;
    private String pictureUrl;
    private String brand;


}
