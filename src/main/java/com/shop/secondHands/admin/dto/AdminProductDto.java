package com.shop.secondHands.admin.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AdminProductDto {

    @NotEmpty(message = "상품명은 필수입니다.")
    private String productName;

    @NotEmpty(message = "상품 설명은 필수입니다.")
    private String productDescription;

    @NotNull(message = "상품 가격을 입력해주세요.")
    private Integer productPrice;

    @NotNull(message = "상품 개수를 입력해주세요.")
    private Integer productQuantity;

    private Boolean productHide;

    private String productEtc;

    @NotEmpty(message = "상품 종류는 필수입니다.")
    private String productType;

    private MultipartFile imageFile;

    public AdminProductDto(String productName, String productDescription, Integer productPrice, Integer productQuantity, Boolean productHide, String productEtc, String productType) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productHide = productHide;
        this.productEtc = productEtc;
        this.productType = productType;
    }
}
