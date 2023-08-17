package com.shop.secondHands.product.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductReview is a Querydsl query type for ProductReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductReview extends EntityPathBase<ProductReview> {

    private static final long serialVersionUID = -884254844L;

    public static final QProductReview productReview = new QProductReview("productReview");

    public final com.shop.secondHands.configuration.QBaseEntity _super = new com.shop.secondHands.configuration.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QProductReview(String variable) {
        super(ProductReview.class, forVariable(variable));
    }

    public QProductReview(Path<? extends ProductReview> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductReview(PathMetadata metadata) {
        super(ProductReview.class, metadata);
    }

}

