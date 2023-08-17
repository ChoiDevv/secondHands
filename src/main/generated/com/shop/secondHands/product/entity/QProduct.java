package com.shop.secondHands.product.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1293053196L;

    public static final QProduct product = new QProduct("product");

    public final com.shop.secondHands.configuration.QBaseEntity _super = new com.shop.secondHands.configuration.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath productDescription = createString("productDescription");

    public final StringPath productEtc = createString("productEtc");

    public final BooleanPath productHide = createBoolean("productHide");

    public final StringPath productImage = createString("productImage");

    public final StringPath productName = createString("productName");

    public final NumberPath<Integer> productPrice = createNumber("productPrice", Integer.class);

    public final NumberPath<Integer> productQuantity = createNumber("productQuantity", Integer.class);

    public final StringPath productType = createString("productType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

