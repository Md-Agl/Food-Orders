package com.md.food.foodorder.dto;

import com.md.food.foodorder.entity.Users;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {

    private String id;
    private String name;
    private String email;


    public static UserResponse fromEntity(Users entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
