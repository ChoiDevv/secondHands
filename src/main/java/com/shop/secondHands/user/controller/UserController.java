package com.shop.secondHands.user.controller;

import com.shop.secondHands.user.dto.*;
import com.shop.secondHands.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/register")
    public String userRegister(UserDto userDto) {
        return "register";
    }

    @PostMapping(value = "/register")
    public String userRegister(@Valid UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.userRegister(userDto, bindingResult);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("registerFailed", "이미 가입된 사용자입니다.");
            return "register";
        } catch (Exception e) {
            bindingResult.reject("registerFailed", e.getMessage());
            return "register";
        }

        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/main/products/{id}/purchase")
    public String singlePurchase(@PathVariable("id") Integer productId, Authentication authentication) {
        userService.singlePurchase(productId, authentication);
        return "main_purchase_question";
    }

    @GetMapping(value = "/main/products/{id}/my-cart")
    public String registerCart(@PathVariable("id") Integer productId, Authentication authentication) {
        userService.registerCart(productId, authentication);
        return "main_basket_completed";
    }

    @GetMapping(value = "/main/purchase")
    public String purchase(Model model, Authentication authentication) {
        List<BasketDto> baskets = userService.purchaseList(authentication);
        PurchaseTotalPriceDto totalPrice = userService.calculateTotalPrice(authentication);
        UserInfoDto userInfo = userService.userInfo(authentication);
        model.addAttribute("baskets", baskets);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("userInfo", userInfo);
        return "main_purchase";
    }

    @GetMapping(value = "/main/my-cart")
    public String myCart(Model model, Authentication authentication) {
        List<BasketDto> baskets = userService.myCart(authentication);
        model.addAttribute("baskets", baskets);
        return "main_basket";
    }

    @GetMapping(value = "/main/my-profile")
    public String myProfile(Model model, Authentication authentication) {
        UserDto userInfo = userService.myProfile(authentication);
        List<UserAddressDto> userAddresses = userService.userAddress(authentication);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userAddresses", userAddresses);
        return "main_profile";
    }

    @GetMapping(value = "/main/basket/{id}")
    public String deleteBaskets(@PathVariable("id") Integer basketId, Authentication authentication) {
        userService.deleteBaskets(basketId, authentication);
        return "redirect:/main";
    }

    @GetMapping(value = "/main/register/address")
    public String myAddress(Authentication authentication) {
        return "main_register_address";
    }

    @PostMapping(value = "/main/register/address")
    public String registerAddress(@Valid UserAddressDto userAddressDto, BindingResult bindingResult, Authentication authentication) {
        try {
            userService.registerAddress(userAddressDto, authentication);
        } catch (Exception e) {
            bindingResult.reject("registerFailed", e.getMessage());
            return "main_register_address";
        }
        return "redirect:/main/my-profile";
    }
}
