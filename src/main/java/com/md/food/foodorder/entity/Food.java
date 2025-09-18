package com.md.food.foodorder.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "foods")
public class Food {

    @Id
    private String id;

    private String name;

    private String description;

    private double price;

    private String categoryName;

    private String imageUrl;

}
