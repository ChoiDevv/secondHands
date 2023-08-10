package com.shop.secondHands.user.controller;

import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/user/register")
    public String userRegister(UserDto userDto) {
        return "user_register";
    }

    @PostMapping(value = "/user/register")
    public String userRegister(@Valid UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user_register";
        }

        try {
            userService.userRegister(userDto, bindingResult);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("registerFailed", "이미 가입된 사용자입니다.");
            return "user_register";
        } catch (Exception e) {
            bindingResult.reject("registerFailed", e.getMessage());
            return "user_register";
        }

        return "redirect:/login";
    }
}
