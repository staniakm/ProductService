package com.example.staniak.product.repository;

import com.example.staniak.product.domain.Product;
import com.example.staniak.product.domain.ProductType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductRepository {
    private Map<Long, Product> products = new HashMap<>();

    public ProductRepository() {
        products.put(1L, new Product(1L, "T-shirt", "Man tshirt", ProductType.MALE, BigDecimal.valueOf(10)));
        products.put(2L, new Product(2L, "Coat", "Winter woman coat", ProductType.FEMALE, BigDecimal.valueOf(600)));
        products.put(3L, new Product(3L, "Shoes", "Kids shoes", ProductType.KID, BigDecimal.valueOf(150)));
        products.put(4L, new Product(4L, "Hat", "Baseball hat", ProductType.KID, BigDecimal.valueOf(120)));
    }

    public Optional<Product> findById(Long productId) {
        if (products.containsKey(productId)) {
            return Optional.of(products.get(productId));
        }
        return Optional.empty();
    }


}
