package com.shop.secondHands.admin.controller;

import com.shop.secondHands.admin.dto.AdminProductDto;
import com.shop.secondHands.admin.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping(value = "/admin/main")
    public String adminMain() {
        return "admin_main";
    }

    @GetMapping(value = "/admin/product/register")
    public String registerProduct(AdminProductDto adminProductDto) {
        return "admin_product_register";
    }

    @PostMapping(value = "/admin/product/register")
    public String registerProduct(@Valid AdminProductDto adminProductDto, BindingResult bindingResult, @RequestParam(value="productImage",required = false) MultipartFile productImage) throws IOException {
        if (bindingResult.hasErrors()) {
            return "admin_product_register";
        }
        adminService.registerProduct(adminProductDto, productImage);
        return "redirect:/admin/main";
    }
}
