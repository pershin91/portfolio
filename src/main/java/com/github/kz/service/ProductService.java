package com.github.kz.service;

import com.github.kz.entity.ProductEntity;
import com.github.kz.model.ProductDto;
import com.github.kz.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity getProductByCode(String code) {
        final Optional<ProductEntity> optionalProduct = productRepository.findFirstByCode(code);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Invalid product code: " + code);
        }

        return optionalProduct.get();
    }

    public void createProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setCode(productDto.getCode());
        productEntity.setPrice(productDto.getPrice());

        productRepository.save(productEntity);
    }
}
