package com.shop.secondHands.user.service;

import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.product.service.ProductServiceImpl;
import com.shop.secondHands.user.dto.BasketDto;
import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.user.entity.Basket;
import com.shop.secondHands.user.entity.UserRole;
import com.shop.secondHands.user.entity.Users;
import com.shop.secondHands.user.exception.UserNotFoundException;
import com.shop.secondHands.user.repository.BasketRepository;
import com.shop.secondHands.user.repository.UserRepository;
import com.shop.secondHands.user.repository.querydsl.DslBasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ProductServiceImpl productService;

    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final DslBasketRepository dslBasketRepository;

    @Override
    public void userRegister(UserDto userDto, BindingResult bindingResult) {
        userRepository.save(Users.toEntity(userDto, UserRole.USER, passwordEncoder));
    }

    @Override
    public void singlePurchase(Integer productId, Authentication authentication) {
        Users currentUser = findByUserId(userRepository.findByUsername(currentUsername(authentication)).get().getId());

        if (basketRepository.existsByUsersAndProduct(currentUser, findByProductId(productId))) {
            Basket basket = findBasket(currentUser, productId);
            basket.count();
            basketRepository.save(basket);
        } else {
            saveBasket(currentUser, productId);
        }
    }

    @Override
    public void registerCart(Integer productId, Authentication authentication) {
        Users currentUser = findByUserId(userRepository.findByUsername(currentUsername(authentication)).get().getId());

        if (basketRepository.existsByUsersAndProduct(currentUser, findByProductId(productId))) {
            Basket basket = findBasket(currentUser, productId);
            basket.count();
            basketRepository.save(basket);
        } else {
            saveBasket(currentUser, productId);
        }
    }

    @Override
    public List<BasketDto> baskets(Authentication authentication) {
        Integer userId = userRepository.findByUsername(currentUsername(authentication)).get().getId();
        return dslBasketRepository.userBaskets(userId);
    }

    @Override
    public List<BasketDto> myCart(Authentication authentication) {
        Integer userId = userRepository.findByUsername(currentUsername(authentication)).get().getId();
        return dslBasketRepository.userBaskets(userId);
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
        basketRepository.save(Basket.toEntity(currentUser, findByProductId(productId), 1));
    }

    public Basket findBasket(Users currentUser, Integer productId) {
        return basketRepository.findByUsersAndProduct(currentUser, findByProductId(productId));
    }
}
