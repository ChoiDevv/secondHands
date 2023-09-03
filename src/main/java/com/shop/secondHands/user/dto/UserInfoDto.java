package com.shop.secondHands.user.dto;

import com.shop.secondHands.user.entity.UserAddress;
import com.shop.secondHands.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {

    private String name;
    private String phoneNumber;
    private String landNumberAddress;
    private String postalCode;

    @Builder
    public UserInfoDto(String name, String phoneNumber, String landNumberAddress, String postalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.landNumberAddress = landNumberAddress;
        this.postalCode = postalCode;
    }

    public static UserInfoDto of(Users user, UserAddress userAddress) {
        return UserInfoDto.builder()
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .landNumberAddress(userAddress.getLandNumberAddress())
                .postalCode(userAddress.getPostalCode())
                .build();
    }
}
