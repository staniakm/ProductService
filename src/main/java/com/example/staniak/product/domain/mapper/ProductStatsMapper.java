package com.example.staniak.product.domain.mapper;

import com.example.staniak.product.domain.ProductStats;
import com.example.staniak.product.domain.dto.ProductStatsDto;

public class ProductStatsMapper {

    public static ProductStatsDto toDto(ProductStats productStats) {
        return new ProductStatsDto(productStats.getVisitCount());
    }
}
