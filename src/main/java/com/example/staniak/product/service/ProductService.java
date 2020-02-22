package com.example.staniak.product.service;

import com.example.staniak.product.domain.dto.ProductDto;
import com.example.staniak.product.domain.mapper.ProductMapper;
import com.example.staniak.product.exception.ProductNotFoundException;
import com.example.staniak.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public ProductDto findProductById(Long productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product id: %d not found", productId)));
    }
}
