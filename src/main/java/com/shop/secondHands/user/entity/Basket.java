package com.shop.secondHands.user.entity;

import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.configuration.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "zh_basket")
public class Basket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column
    private Integer count;

    @Builder
    public Basket(Users users, Product product, Integer count) {
        this.users = users;
        this.product = product;
        this.count = count;
    }

    public static Basket toEntity(Users users, Product product, Integer count) {
        return Basket.builder()
                .users(users)
                .product(product)
                .count(count)
                .build();
    }

    public void count() {
        this.count += 1;
    }
}
