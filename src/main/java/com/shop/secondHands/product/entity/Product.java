package com.shop.secondHands.product.entity;

import com.shop.secondHands.admin.dto.AdminProductDto;
import com.shop.secondHands.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "sh_product")
public class Product extends BaseEntity {

    @Column
    private String productName;

    @Column
    private String productImage;

    @Column
    private String productDescription;

    @Column
    private Integer productPrice;

    @Column
    private Integer productQuantity;

    @Column
    private Boolean productHide;

//    @OneToMany(mappedBy = "sh_product_review")
//    private List<ProductReview> reviews = new ArrayList<>();

    @Column
    private String productEtc;

    @Builder
    public Product(String productName, String productImage, String productDescription, Integer productPrice, Integer productQuantity, Boolean productHide, String productEtc) {
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productHide = productHide;
        this.productEtc = productEtc;
    }

    public static Product toEntity(AdminProductDto adminProductDto, Boolean productHide) {
        return Product.builder()
                .productName(adminProductDto.getProductName())
                .productImage(adminProductDto.getProductImage())
                .productDescription(adminProductDto.getProductDescription())
                .productPrice(adminProductDto.getProductPrice())
                .productQuantity(adminProductDto.getProductQuantity())
                .productHide(productHide)
                .productEtc(adminProductDto.getProductEtc())
                .build();
    }
}
