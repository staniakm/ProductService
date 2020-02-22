package com.example.staniak.product.domain.dto;

import com.example.staniak.product.domain.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private ProductType productType;
    private BigDecimal price;
}
