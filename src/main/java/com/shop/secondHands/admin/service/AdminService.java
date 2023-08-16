package com.shop.secondHands.admin.service;

import com.shop.secondHands.admin.dto.AdminProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface AdminService {
    void registerProduct(AdminProductDto adminProductDto, MultipartFile productImage) throws IOException;
}
