package com.shop.secondHands.user.service;

import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.product.service.ProductServiceImpl;
import com.shop.secondHands.user.dto.BasketDto;
import com.shop.secondHands.user.dto.UserAddressDto;
import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.user.entity.Basket;
import com.shop.secondHands.user.entity.UserAddress;
import com.shop.secondHands.user.entity.UserRole;
import com.shop.secondHands.user.entity.Users;
import com.shop.secondHands.user.exception.BasketNotFoundException;
import com.shop.secondHands.user.exception.UserNotFoundException;
import com.shop.secondHands.user.repository.BasketRepository;
import com.shop.secondHands.user.repository.UserAddressRepository;
import com.shop.secondHands.user.repository.UserRepository;
import com.shop.secondHands.user.repository.querydsl.DslBasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final ProductServiceImpl productService;

    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final UserAddressRepository userAddressRepository;
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
    public List<BasketDto> purchaseList(Authentication authentication) {
        Integer userId = userId(authentication);
        Integer totalPrice = 0;
        List<BasketDto> baskets = dslBasketRepository.userBaskets(userId);

        for (BasketDto basket: baskets) {
            totalPrice = totalPrice + basket.getBasketPrice();
            basket.setTotalPrice(totalPrice);
        }

        return baskets;
    }

    @Override
    public List<BasketDto> myCart(Authentication authentication) {
        Integer userId = userId(authentication);
        return dslBasketRepository.userBaskets(userId);
    }

    @Override
    public UserDto myProfile(Authentication authentication) {
        Integer userId = userId(authentication);
        return UserDto.of(findByUserId(userId));
    }

    @Override
    public void deleteBaskets(Integer basketId, Authentication authentication) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new BasketNotFoundException("존재하지 않는 장바구니입니다."));

        if (!basket.getUsers().getUsername().equals(currentUsername(authentication))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        basketRepository.delete(basket);
    }

    @Override
    public List<UserAddressDto> userAddress(Authentication authentication) {
        Users currentUser = findByUserId(userId(authentication));
        return UserAddressDto.of(userAddressRepository.findByUsers(currentUser));
    }

    @Override
    public void registerAddress(UserAddressDto userAddressDto, Authentication authentication) {
        Users currentUser = findByUserId(userRepository.findByUsername(currentUsername(authentication)).get().getId());
        userAddressRepository.save(UserAddress.toEntity(userAddressDto, currentUser));
    }

    private Integer userId(Authentication authentication) {
        return userRepository.findByUsername(currentUsername(authentication)).get().getId();
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
