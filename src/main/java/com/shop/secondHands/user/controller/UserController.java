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


}
