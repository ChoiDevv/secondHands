package com.shop.secondHands.user.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.shop.secondHands.user.dto.QBasketDto is a Querydsl Projection type for BasketDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBasketDto extends ConstructorExpression<BasketDto> {

    private static final long serialVersionUID = -1195990832L;

    public QBasketDto(com.querydsl.core.types.Expression<Integer> userId, com.querydsl.core.types.Expression<String> username, com.querydsl.core.types.Expression<Integer> basketId, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<Integer> productPrice, com.querydsl.core.types.Expression<String> productImage, com.querydsl.core.types.Expression<String> productDescription, com.querydsl.core.types.Expression<Integer> selectedQuantity, com.querydsl.core.types.Expression<String> productEtc, com.querydsl.core.types.Expression<Integer> basketPrice) {
        super(BasketDto.class, new Class<?>[]{int.class, String.class, int.class, String.class, int.class, String.class, String.class, int.class, String.class, int.class}, userId, username, basketId, productName, productPrice, productImage, productDescription, selectedQuantity, productEtc, basketPrice);
    }

}

