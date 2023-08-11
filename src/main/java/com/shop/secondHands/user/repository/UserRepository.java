package com.shop.secondHands.user.repository;

import com.shop.secondHands.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Boolean existsByUsername(String username);
    Optional<Users> findByUsername(String username);
}
