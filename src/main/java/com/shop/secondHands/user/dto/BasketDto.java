package com.shop.secondHands.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class BasketDto {

    private Integer userId;
    private String username;
    private Integer basketId;
    private String productName;
    private Integer productPrice;
    private String productImage;
    private String productDescription;
    private Integer selectedQuantity;
    private String productEtc;
    private Integer basketPrice;

    @QueryProjection
    public BasketDto(Integer userId, String username, Integer basketId, String productName, Integer productPrice, String productImage, String productDescription, Integer selectedQuantity, String productEtc, Integer basketPrice) {
        this.userId = userId;
        this.username = username;
        this.basketId = basketId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.selectedQuantity = selectedQuantity;
        this.productEtc = productEtc;
        this.basketPrice = basketPrice;
    }
}
