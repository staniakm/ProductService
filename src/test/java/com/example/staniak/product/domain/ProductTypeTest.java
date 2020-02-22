package com.example.staniak.product.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static com.example.staniak.product.domain.ProductType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTypeTest {

    @ParameterizedTest
    @MethodSource("provideEnumWitExpectedDiscount")
    void calculateDiscount(ProductType productType, BigDecimal expectedPrice) {
        //given
        BigDecimal productPrice = BigDecimal.valueOf(100);

        //when
        final BigDecimal actualPrice = productType.calculateDiscount(productPrice);

        //then
        assertEquals(expectedPrice, actualPrice);
    }

    private static Stream<Arguments> provideEnumWitExpectedDiscount() {
        return Stream.of(
                Arguments.of(MALE, BigDecimal.valueOf(95).setScale(2, BigDecimal.ROUND_HALF_UP)),
                Arguments.of(FEMALE, BigDecimal.valueOf(95).setScale(2, BigDecimal.ROUND_HALF_UP)),
                Arguments.of(KID, BigDecimal.valueOf(90).setScale(2, BigDecimal.ROUND_HALF_UP))
        );
    }
}