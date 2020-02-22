package com.example.staniak.product.domain.mapper;

import com.example.staniak.product.domain.Product;
import com.example.staniak.product.domain.dto.ProductDto;
import com.example.staniak.product.service.DiscountCalculator;

import java.math.BigDecimal;

public class ProductMapper {

    public static ProductDto toDto(Product product, DiscountCalculator discountCalculator) {
        final BigDecimal productPrice = discountCalculator.getPriceAfterDiscount(product);
        return new ProductDto(product.getName(), product.getDescription(), product.getProductType(),
                productPrice);
    }
}
