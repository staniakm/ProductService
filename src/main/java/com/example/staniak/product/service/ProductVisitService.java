package com.example.staniak.product.service;

import com.example.staniak.product.repository.ProductVisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductVisitService {

    private ProductVisitRepository productVisitRepository;

    public void increaseVisitCounter(Long productId) {
        productVisitRepository.increaseVisitCount(productId);
    }

    public int getVisitCount(Long productId) {
        return productVisitRepository.getVisitCount(productId);
    }
}
