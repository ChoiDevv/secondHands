package com.shop.secondHands.product.controller;

import com.shop.secondHands.product.dto.ProductDto;
import com.shop.secondHands.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/main/products")
    public String products(Model model) {
        List<ProductDto> products = productService.products();
        model.addAttribute("products", products);
        return "main";
    }
}