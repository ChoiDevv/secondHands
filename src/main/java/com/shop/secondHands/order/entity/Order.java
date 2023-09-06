package com.shop.secondHands.order.entity;

import com.shop.secondHands.configuration.BaseEntity;
import com.shop.secondHands.user.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "sh_order")
public class Order extends BaseEntity {

    @Column
    private String orderNumber;

    @Column
    private String username;

    @Column
    private Integer amount;

    @Builder
    public Order(String orderNumber, String username, Integer amount) {
        this.orderNumber = orderNumber;

        this.username = username;
        this.amount = amount;
    }

    public static Order toEntity(Users currentUser, String merchantUid, int amount) {
        return Order.builder()
                .username(currentUser.getUsername())
                .amount(amount)
                .orderNumber(merchantUid)
                .build();
    }
}
