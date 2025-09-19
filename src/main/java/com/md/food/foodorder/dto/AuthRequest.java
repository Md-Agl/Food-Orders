package com.md.food.foodorder.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthRequest {

    private String email;
    private String password;
}
