package com.shop.secondHands.user.dto;

import com.shop.secondHands.user.entity.UserAddress;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserAddressDto {

    private Integer userId;
    private String postalCode;
    private String roadNameAddress;
    private String landNumberAddress;
    private String detailedAddress;
    private String reference;

    @Builder
    public UserAddressDto(Integer userId, String postalCode, String roadNameAddress, String landNumberAddress, String detailedAddress, String reference) {
        this.userId = userId;
        this.postalCode = postalCode;
        this.roadNameAddress = roadNameAddress;
        this.landNumberAddress = landNumberAddress;
        this.detailedAddress = detailedAddress;
        this.reference = reference;
    }

    public static List<UserAddressDto> of(List<UserAddress> addresses) {
        List<UserAddressDto> dto = new ArrayList<>();

        for (UserAddress address: addresses) {
            dto.add(
                    UserAddressDto.builder()
                            .userId(address.getUsers().getId())
                            .postalCode(address.getPostalCode())
                            .roadNameAddress(address.getRoadNameAddress())
                            .landNumberAddress(address.getLandNumberAddress())
                            .detailedAddress(address.getDetailedAddress())
                            .reference(address.getReference())
                            .build()
            );
        }
        return dto;
    }
}
