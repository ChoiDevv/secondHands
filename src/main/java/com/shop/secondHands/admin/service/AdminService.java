package com.shop.secondHands.admin.service;

import com.shop.secondHands.admin.dto.AdminProductDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    void registerProduct(AdminProductDto adminProductDto);
}
