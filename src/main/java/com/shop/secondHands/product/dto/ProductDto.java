package com.shop.secondHands.product.dto;

import com.shop.secondHands.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductDto {

    private Integer productId;
    private String productName;
    private String productImage;
    private String productDescription;
    private Integer productPrice;
    private Integer productQuantity;
    private Boolean productHide;
    private String productEtc;
    private String productType;

    @Builder
    public ProductDto(Integer productId, String productName, String productImage, String productDescription, Integer productPrice, Integer productQuantity, Boolean productHide, String productEtc, String productType) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productHide = productHide;
        this.productEtc = productEtc;
        this.productType = productType;
    }

    public static List<ProductDto> of(List<Product> productList) {
        List<ProductDto> dto = new ArrayList<>();

        for (Product product: productList) {
            dto.add(
                    ProductDto.builder()
                            .productId(product.getId())
                            .productName(product.getProductName())
                            .productImage(product.getProductImage())
                            .productDescription(product.getProductDescription())
                            .productPrice(product.getProductPrice())
                            .productQuantity(product.getProductQuantity())
                            .productHide(product.getProductHide())
                            .productEtc(product.getProductEtc())
                            .productType(product.getProductType())
                            .build()
            );
        }
        return dto;
    }

    public static ProductDto of(Product product) {
        return ProductDto.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .productImage(product.getProductImage())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productQuantity(product.getProductQuantity())
                .productHide(product.getProductHide())
                .productEtc(product.getProductEtc())
                .productType(product.getProductType())
                .build();
    }
}
