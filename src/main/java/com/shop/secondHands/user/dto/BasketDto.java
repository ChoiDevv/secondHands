package com.shop.secondHands.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BasketDto {

    private Integer userId;
    private String productName;
    private String productImage;
    private String productDescription;
    private Integer selectedQuantity;
    private String productEtc;

    @QueryProjection
    public BasketDto(Integer userId, String productName, String productImage, String productDescription, Integer selectedQuantity, String productEtc) {
        this.userId = userId;
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.selectedQuantity = selectedQuantity;
        this.productEtc = productEtc;
    }
}
