package com.example.staniak.product.domain;

import java.math.BigDecimal;

public enum ProductType {
    MALE {
        //5% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(0.95));
        }
    }, FEMALE {
        //5% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(0.95));
        }
    }, KID {
        //10% discount
        @Override
        public BigDecimal calculateDiscount(BigDecimal price) {
            return price.multiply(BigDecimal.valueOf(0.90));
        }
    };

    public abstract BigDecimal calculateDiscount(BigDecimal price);
}
