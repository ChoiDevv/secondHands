package com.shop.secondHands.product.controller;

import com.shop.secondHands.product.dto.ProductDto;
import com.shop.secondHands.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/main")
    public String products(Model model) {
        List<ProductDto> products = productService.products();
        model.addAttribute("products", products);
        return "main_products";
    }

    @GetMapping(value = "/main/products/{id}")
    public String product(@PathVariable("id") Integer id, Model model) {
        ProductDto product = productService.product(id);
        model.addAttribute("product", product);
        return "main_product";
    }

    @GetMapping(value = "/search")
    public String productSearch(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model model) {
        List<ProductDto> products = productService.productSearch(keyword);
        model.addAttribute("products", products);
        return "main_product_search";
    }
}
