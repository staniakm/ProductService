package com.example.staniak.product.domain.mapper;

import com.example.staniak.product.domain.Product;
import com.example.staniak.product.domain.dto.ProductDto;

import java.math.BigDecimal;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        final BigDecimal productPrice = product.getProductType().calculateDiscount(product.getPrice());
        return new ProductDto(product.getName(), product.getDescription(), product.getProductType(),
                productPrice);
    }
}
