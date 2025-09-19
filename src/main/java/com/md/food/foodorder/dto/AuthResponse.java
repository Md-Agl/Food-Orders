package com.md.food.foodorder.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthResponse {

    private String email;
    private String token;
}
