package com.shop.secondHands.admin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AdminProductDto {

    @NotEmpty(message = "상품명은 필수입니다.")
    private String productName;

    @NotEmpty(message = "상품 이미지는 필수입니다.")
    private String productImage;

    @NotEmpty(message = "상품 설명은 필수입니다.")
    private String productDescription;

    private Integer productPrice;

    private Integer productQuantity;

    private Boolean productHide;

    private String productEtc;

    @Builder
    public AdminProductDto(String productName, String productImage, String productDescription, Integer productPrice, Integer productQuantity, Boolean productHide, String productEtc) {
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productHide = productHide;
        this.productEtc = productEtc;
    }
}
