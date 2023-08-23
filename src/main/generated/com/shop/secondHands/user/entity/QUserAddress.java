package com.shop.secondHands.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAddress is a Querydsl query type for UserAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAddress extends EntityPathBase<UserAddress> {

    private static final long serialVersionUID = 201006008L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAddress userAddress = new QUserAddress("userAddress");

    public final com.shop.secondHands.configuration.QBaseEntity _super = new com.shop.secondHands.configuration.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath detailedAddress = createString("detailedAddress");

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath landNumberAddress = createString("landNumberAddress");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath reference = createString("reference");

    public final StringPath roadNameAddress = createString("roadNameAddress");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public final QUsers users;

    public QUserAddress(String variable) {
        this(UserAddress.class, forVariable(variable), INITS);
    }

    public QUserAddress(Path<? extends UserAddress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAddress(PathMetadata metadata, PathInits inits) {
        this(UserAddress.class, metadata, inits);
    }

    public QUserAddress(Class<? extends UserAddress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

