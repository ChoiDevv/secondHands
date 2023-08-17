package com.shop.secondHands.user.entity;

import com.shop.secondHands.user.dto.UserDto;
import com.shop.secondHands.configuration.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "sh_users")
public class Users extends BaseEntity {

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String sex;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserRole role;

    @Builder
    public Users(String username, String password, String name, String city, String sex, String phoneNumber, UserRole role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.city = city;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public static Users toEntity(UserDto userDto, UserRole userRole, PasswordEncoder passwordEncoder) {
        return Users.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .city(userDto.getCity())
                .sex(userDto.getSex())
                .phoneNumber(userDto.getPhoneNumber())
                .role(userRole)
                .build();
    }
}
