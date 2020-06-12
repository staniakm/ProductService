package com.example.staniak.product.service;

import com.example.staniak.product.domain.dto.ProductStatsDto;
import com.example.staniak.product.domain.mapper.ProductStatsMapper;
import com.example.staniak.product.exception.ProductNotFoundException;
import com.example.staniak.product.repository.ProductStatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Service
@AllArgsConstructor
@Transactional(isolation = Isolation.READ_COMMITTED)
public class ProductVisitService {

    private final ProductStatsRepository productStatsRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void increaseVisitCounter(Long productId) {
        productStatsRepository.increaseVisitCount(productId);
    }

    public ProductStatsDto getProductStats(Long productId) {
        return productStatsRepository.findByProductId(productId).map(ProductStatsMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(format("Stats for product id: %d not found", productId)));
    }
}
