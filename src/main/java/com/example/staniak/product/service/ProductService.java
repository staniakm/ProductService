package com.example.staniak.product.service;

import com.example.staniak.product.domain.dto.ProductDto;
import com.example.staniak.product.domain.mapper.ProductMapper;
import com.example.staniak.product.exception.ProductNotFoundException;
import com.example.staniak.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final DiscountCalculator discountCalculator;

    public ProductDto findProductById(Long productId) {

        return productRepository.findById(productId)
                .map(product -> ProductMapper.toDto(product, discountCalculator))
                .orElseThrow(() -> new ProductNotFoundException(format("Product id: %d not found", productId)));
    }
}
