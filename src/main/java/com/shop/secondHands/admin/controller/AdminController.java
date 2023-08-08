package com.shop.secondHands.admin.controller;

import com.shop.secondHands.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
}
