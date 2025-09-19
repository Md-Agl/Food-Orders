package com.md.food.foodorder.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "users")
public class Users {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;
}
