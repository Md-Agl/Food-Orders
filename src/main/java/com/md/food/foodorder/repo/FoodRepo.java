package com.md.food.foodorder.repo;

import com.md.food.foodorder.entity.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends MongoRepository<Food, String> {
}
