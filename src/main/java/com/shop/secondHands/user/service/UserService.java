package com.shop.secondHands.user.service;

import com.shop.secondHands.user.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface UserService {
    void userRegister(UserDto userDto, BindingResult bindingResult);
}
