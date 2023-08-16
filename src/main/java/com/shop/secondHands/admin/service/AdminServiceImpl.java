package com.shop.secondHands.admin.service;

import com.shop.secondHands.admin.dto.AdminProductDto;
import com.shop.secondHands.product.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ProductServiceImpl productService;

    @Override
    public void registerProduct(AdminProductDto adminProductDto, MultipartFile productImage) throws IOException {
        productService.save(adminProductDto, true, productImage);
    }
}
