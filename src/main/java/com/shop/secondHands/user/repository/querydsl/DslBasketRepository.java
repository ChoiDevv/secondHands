package com.shop.secondHands.user.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.secondHands.user.dto.BasketDto;
import com.shop.secondHands.user.dto.QBasketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.shop.secondHands.user.entity.QUsers.users;
import static com.shop.secondHands.user.entity.QBasket.basket;
import static com.shop.secondHands.product.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class DslBasketRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<BasketDto> userBaskets(Integer userId) {
        return jpaQueryFactory
                .select(new QBasketDto(basket.users.id, users.username, basket.id, product.productName, product.productImage, product.productDescription, basket.count, product.productEtc))
                .from(basket)
                .innerJoin(users).on(basket.users.id.eq(users.id))
                .innerJoin(product).on(basket.product.id.eq(product.id))
                .where(basket.users.id.eq(userId))
                .fetchJoin()
                .fetch();
    }
}
