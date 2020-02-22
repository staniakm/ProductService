package com.example.staniak.product.repository;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ProductVisitRepository {

    private Map<Long, AtomicInteger> visitCount = new ConcurrentHashMap<>();

    synchronized public void increaseVisitCount(Long productId) {
        visitCount.putIfAbsent(productId, new AtomicInteger(0));
        visitCount.get(productId).incrementAndGet();
    }

    public Integer getVisitCount(Long productId) {
        return visitCount.getOrDefault(productId, new AtomicInteger(0)).get();
    }

}
