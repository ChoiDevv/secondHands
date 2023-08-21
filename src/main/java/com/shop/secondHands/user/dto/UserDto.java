package com.shop.secondHands.user.dto;

import com.shop.secondHands.user.entity.Users;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "아이디를 입력하세요.")
    private String username;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    @NotEmpty(message = "도시를 입력하세요.")
    private String city;

    @NotEmpty(message = "성별을 입력하세요.")
    private String sex;

    @NotEmpty(message = "휴대폰 번호를 입력하세요.")
    private String phoneNumber;

    @Builder
    public UserDto(String username, String password, String name, String city, String sex, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.city = city;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    public static UserDto of(Users user) {
        return UserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .city(user.getCity())
                .sex(user.getSex())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
