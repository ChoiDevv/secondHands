package com.shop.secondHands.user.service;

import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.product.service.ProductServiceImpl;
import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.user.entity.Basket;
import com.shop.secondHands.user.entity.UserRole;
import com.shop.secondHands.user.entity.Users;
import com.shop.secondHands.user.exception.UserNotFoundException;
import com.shop.secondHands.user.repository.BasketRepository;
import com.shop.secondHands.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final ProductServiceImpl productService;

    @Override
    public void userRegister(UserDto userDto, BindingResult bindingResult) {
        userRepository.save(Users.toEntity(userDto, UserRole.USER, passwordEncoder));
    }

    @Override
    public void singlePurchase(Integer productId, Authentication authentication) {

        Users currentUser = findByUserId(userRepository.findByUsername(currentUsername(authentication)).get().getId());

        if (basketRepository.existsByUsersAndProduct(currentUser, findByProductId(productId))) {
            Basket basket = findBasket(currentUser, productId);
            Integer count = basket.getCount();
            count += 1;
            basketRepository.save(basket);
        } else {
            saveBasket(currentUser, productId);
        }
    }

    private String currentUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    public Users findByUserId(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("유저를 찾을수 없습니다."));
    }

    public Product findByProductId(Integer id) {
        return productService.findByProductId(id);
    }

    public void saveBasket(Users currentUser, Integer productId) {
        basketRepository.save(Basket.toEntity(currentUser, findByProductId(productId), 0));
    }

    public Basket findBasket(Users currentUser, Integer productId) {
        return basketRepository.findByUsersAndProduct(currentUser, findByProductId(productId));
    }
}
