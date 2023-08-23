package com.shop.secondHands.user.entity;

import com.shop.secondHands.configuration.BaseEntity;
import com.shop.secondHands.user.dto.UserAddressDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "zh_user_address")
public class UserAddress extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column
    private String postalCode;

    @Column
    private String roadNameAddress;

    @Column
    private String landNumberAddress;

    @Column
    private String detailedAddress;

    @Column
    private String reference;

    @Builder
    public UserAddress(Users users, String postalCode, String roadNameAddress, String landNumberAddress, String detailedAddress, String reference) {
        this.users = users;
        this.postalCode = postalCode;
        this.roadNameAddress = roadNameAddress;
        this.landNumberAddress = landNumberAddress;
        this.detailedAddress = detailedAddress;
        this.reference = reference;
    }

    public static UserAddress toEntity(UserAddressDto userAddressDto, Users currentUser) {
        return UserAddress.builder()
                .users(currentUser)
                .postalCode(userAddressDto.getPostalCode())
                .roadNameAddress(userAddressDto.getRoadNameAddress())
                .landNumberAddress(userAddressDto.getLandNumberAddress())
                .detailedAddress(userAddressDto.getDetailedAddress())
                .reference(userAddressDto.getReference())
                .build();
    }
}
