package com.shop.secondHands.user.service;

import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.user.entity.UserRole;
import com.shop.secondHands.user.entity.Users;
import com.shop.secondHands.user.exception.UserDuplicatedException;
import com.shop.secondHands.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void userRegister(UserDto userDto, BindingResult bindingResult) {
        userRepository.save(Users.toEntity(userDto, UserRole.USER, passwordEncoder));
    }
}
