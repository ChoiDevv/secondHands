package com.shop.secondHands.product.service;

import com.shop.secondHands.product.dto.ProductDto;
import com.shop.secondHands.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> products() {
        return ProductDto.of(productRepository.findAll());
    }
}
