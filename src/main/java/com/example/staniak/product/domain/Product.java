package com.example.staniak.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private ProductType productType;
    private BigDecimal price;
}
