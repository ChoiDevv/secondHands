package com.shop.secondHands.user.repository;

import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.user.entity.Basket;
import com.shop.secondHands.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Boolean existsByUsersAndProduct(Users users, Product product);
    Basket findByUsersAndProduct(Users users, Product product);
    List<Basket> findByUsers(Users users);
    void deleteByUsers(Users users);
}
