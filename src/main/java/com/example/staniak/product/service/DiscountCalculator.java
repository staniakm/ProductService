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

    private DiscountRepository discountRepository;

    public BigDecimal getPriceAfterDiscount(Product product) {

        final Integer discountPercent = discountRepository.getProductTypeDiscountByProductId(product.getId())
                .map(ProductTypeDiscount::getDiscountPercent).orElse(0);
        return product.getPrice()
                .multiply(BigDecimal.valueOf(100 - discountPercent)
                        .divide(BigDecimal.valueOf(100), 2, RoundingMode.CEILING));
    }

}
