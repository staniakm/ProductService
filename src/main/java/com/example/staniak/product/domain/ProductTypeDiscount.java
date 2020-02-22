package com.example.staniak.product.domain;

import lombok.Getter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter
public class ProductTypeDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Integer discountPercent;
}
