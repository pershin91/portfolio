package com.github.kz.controller;

import com.github.kz.entity.ProductEntity;
import com.github.kz.model.ProductDto;
import com.github.kz.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product/{code}")
    public ProductEntity getUser(@PathVariable("code") String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto product) {
        productService.createProduct(product);
    }
}
