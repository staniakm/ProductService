package com.example.staniak.product.repository;

import com.example.staniak.product.domain.ProductTypeDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface DiscountRepository extends JpaRepository<ProductTypeDiscount, Long> {

    @Query("select t from ProductTypeDiscount t join Product p on p.productType = t.productType where p.id = :productId")
    Optional<ProductTypeDiscount> getProductTypeDiscountByProductId(Long productId);

}
