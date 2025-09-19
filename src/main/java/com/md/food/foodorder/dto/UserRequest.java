package com.md.food.foodorder.dto;

import com.md.food.foodorder.entity.Users;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

    private String name;
    private String email;
    private String password;

    public static Users toEntity(UserRequest request) {
        return Users.builder()
                .name(request.name)
                .email(request.email)
                .password(request.password)
                .build();
    }
}
