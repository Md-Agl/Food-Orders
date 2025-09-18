package com.md.food.foodorder.dto;


import com.md.food.foodorder.entity.Food;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FoodGeneralDTO {

    private String foodId;
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private String imageUrl;

    //Entity -> DTO
    public static FoodGeneralDTO fromEntity(Food entity) {
        return FoodGeneralDTO.builder()
                .foodId(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .categoryName(entity.getCategoryName())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .build();
    }

    //Convert DTO to Entity
    public Food toEntity() {
        return Food.builder()
                .id(UUID.randomUUID().toString())
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .categoryName(this.categoryName)
                .build();
    }
}
