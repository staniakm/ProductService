package com.example.staniak.product.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ProductType {
    MALE {
        //5% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(FIVE_PERCENT_DISCOUNT)).setScale(2, RoundingMode.CEILING);
        }
    }, FEMALE {
        //5% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(FIVE_PERCENT_DISCOUNT)).setScale(2, RoundingMode.CEILING);
        }
    }, KID {
        //10% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(TEN_PERCENT_DISCOUNT)).setScale(2, RoundingMode.CEILING);
        }
    };

    private static final double FIVE_PERCENT_DISCOUNT = 0.95;
    private static final double TEN_PERCENT_DISCOUNT = 0.90;

    public abstract BigDecimal calculateDiscount(BigDecimal price);
}
