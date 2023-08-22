package com.shop.secondHands.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasketDto {

    private Integer userId;
    private String username;
    private Integer basketId;
    private String productName;
    private String productImage;
    private String productDescription;
    private Integer selectedQuantity;
    private String productEtc;

    @QueryProjection
    public BasketDto(Integer userId, String username, Integer basketId, String productName, String productImage, String productDescription, Integer selectedQuantity, String productEtc) {
        this.userId = userId;
        this.username = username;
        this.basketId = basketId;
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.selectedQuantity = selectedQuantity;
        this.productEtc = productEtc;
    }
}
