package com.shop.secondHands.user.service;

import com.shop.secondHands.user.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.security.Principal;

@Service
public interface UserService {
    void userRegister(UserDto userDto, BindingResult bindingResult);

    void singlePurchase(Integer productId, Authentication authentication);

    void registerCart(Integer productId, Authentication authentication);
}
