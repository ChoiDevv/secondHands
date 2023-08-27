package com.shop.secondHands.user.service;

import com.shop.secondHands.user.dto.BasketDto;
import com.shop.secondHands.user.dto.PurchaseTotalPriceDto;
import com.shop.secondHands.user.dto.UserAddressDto;
import com.shop.secondHands.user.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.security.Principal;
import java.util.List;

@Service
public interface UserService {
    void userRegister(UserDto userDto, BindingResult bindingResult);

    void singlePurchase(Integer productId, Authentication authentication);

    void registerCart(Integer productId, Authentication authentication);

    List<BasketDto> purchaseList(Authentication authentication);

    List<BasketDto> myCart(Authentication authentication);

    UserDto myProfile(Authentication authentication);

    void deleteBaskets(Integer basketId, Authentication authentication);

    List<UserAddressDto> userAddress(Authentication authentication);

    void registerAddress(UserAddressDto userAddressDto, Authentication authentication);

    PurchaseTotalPriceDto calculateTotalPrice(Authentication authentication);
}
