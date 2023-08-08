package com.shop.secondHands.product.entity;

import com.shop.secondHands.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "sh_product_review")
public class ProductReview extends BaseEntity {
}
