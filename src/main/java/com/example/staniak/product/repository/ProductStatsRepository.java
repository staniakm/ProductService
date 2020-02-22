package com.example.staniak.product.repository;

import com.example.staniak.product.domain.ProductStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductStatsRepository extends JpaRepository<ProductStats, Long> {

    @Modifying
    @Query(value = "update product_stats set visit_count = visit_count + 1 where product_id = :productId", nativeQuery = true)
    void increaseVisitCount(@Param("productId") Long productId);


    Optional<ProductStats> findByProductId(Long productId);
}
