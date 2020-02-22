package com.example.staniak.product.controller;

import com.example.staniak.product.domain.dto.ProductDto;
import com.example.staniak.product.domain.dto.ProductStatsDto;
import com.example.staniak.product.service.ProductService;
import com.example.staniak.product.service.ProductVisitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private ProductVisitService productVisitService;

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        final ProductDto product = productService.findProductById(id);
        productVisitService.increaseVisitCounter(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("{id}/stats")
    public ResponseEntity<ProductStatsDto> getProductStats(@PathVariable Long id) {
        final ProductStatsDto productStats = productVisitService.getProductStats(id);
        return new ResponseEntity<>(productStats, HttpStatus.OK);
    }
}
