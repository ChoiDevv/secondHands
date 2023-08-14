package com.shop.secondHands.product.service;

import com.shop.secondHands.admin.dto.AdminProductDto;
import com.shop.secondHands.product.dto.ProductDto;
import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.product.exception.ProductNotFoundException;
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

    @Override
    public ProductDto product(Integer id) {
        return ProductDto.of(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("해당 게시물을 찾을 수 없습니다.")));
    }

    public void save(AdminProductDto adminProductDto, Boolean productHide) {
        productRepository.save(Product.toEntity(adminProductDto, productHide));
    }

    public Product findByProductId(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("상품을 찾을 수 없습니다."));
    }
}
