package com.shop.secondHands.product.service;

import com.shop.secondHands.product.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> products();

    ProductDto product(Integer id);

    List<ProductDto> productSearch(String keyword);
}
