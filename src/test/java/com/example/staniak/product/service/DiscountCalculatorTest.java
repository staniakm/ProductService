package com.example.staniak.product.service;

import com.example.staniak.product.domain.Product;
import com.example.staniak.product.domain.ProductType;
import com.example.staniak.product.domain.ProductTypeDiscount;
import com.example.staniak.product.repository.DiscountRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    private final DiscountRepository repository = mock(DiscountRepository.class);


    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculator(repository);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void shouldCalculateDiscount(Product product, Optional<ProductTypeDiscount> discount, BigDecimal expectedPrice) {
        //given
        given(repository.getProductTypeDiscountByProductId(product.getId())).willReturn(discount);
        //when
        BigDecimal newPrice = calculator.getPriceAfterDiscount(product);

        //then
        assertThat(expectedPrice, Matchers.comparesEqualTo(newPrice));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(
                        new Product(1L, "Milk", "Description", ProductType.FEMALE, BigDecimal.TEN),
                        Optional.of(new ProductTypeDiscount(1L, ProductType.FEMALE, 10)),
                        new BigDecimal("9.00")),
                Arguments.of(
                        new Product(1L, "Milk", "Description", ProductType.FEMALE, BigDecimal.TEN),
                        Optional.of(new ProductTypeDiscount(1L, ProductType.FEMALE, 0)),
                        new BigDecimal("10.00")),
                Arguments.of(
                        new Product(1L, "Milk", "Description", ProductType.FEMALE, BigDecimal.TEN),
                        Optional.empty(),
                        new BigDecimal("10.00"))
        );
    }
}
