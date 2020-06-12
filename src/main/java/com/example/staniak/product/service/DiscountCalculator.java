package com.example.staniak.product.service;

import com.example.staniak.product.domain.Product;
import com.example.staniak.product.domain.ProductTypeDiscount;
import com.example.staniak.product.repository.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@AllArgsConstructor
public class DiscountCalculator {

    private final DiscountRepository discountRepository;

    public BigDecimal getPriceAfterDiscount(Product product) {

        return discountRepository.getProductTypeDiscountByProductId(product.getId())
                .map(ProductTypeDiscount::getDiscountPercent)
                .map(discount ->
                        product.getPrice()
                                .multiply(BigDecimal.valueOf(100 - discount)
                                        .divide(BigDecimal.valueOf(100), 2, RoundingMode.CEILING)))
                .orElseGet(() -> product.getPrice());
    }

}
