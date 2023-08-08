package com.shop.secondHands.product.entity;

import com.shop.secondHands.utils.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private BigDecimal productPrice;

    @Column
    private BigDecimal productQuantity;

    @Column
    private Boolean productHide;

//    @OneToMany(mappedBy = "sh_product_review")
//    private List<ProductReview> reviews = new ArrayList<>();

    @Column
    private String productEtc;
}
