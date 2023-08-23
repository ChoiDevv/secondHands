package com.shop.secondHands.user.repository;

import com.shop.secondHands.user.entity.UserAddress;
import com.shop.secondHands.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

    List<UserAddress> findByUsers(Users users);
}
