package com.shop.secondHands.order.controller;

import com.shop.secondHands.order.service.OrderService;
import com.siot.IamportRestClient.exception.IamportResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/main/purchase/card")
    public String purchase(@RequestBody Map<String, String> data, Authentication authentication) throws IamportResponseException, IOException {
        orderService.purchase(data, authentication);
        return "main_purchase_completed";
    }

    @GetMapping(value = "/main/purchase/card")
    public String purchaseCompleted() {
        return "main_purchase_completed";
    }
}
