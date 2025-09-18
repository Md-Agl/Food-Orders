package com.md.food.foodorder.service;

import com.md.food.foodorder.dto.FoodGeneralDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {

    //add food
    FoodGeneralDTO addFood(FoodGeneralDTO request, MultipartFile file);

    //get food by id
    FoodGeneralDTO getFoodById(String id);

    //get all food
    List<FoodGeneralDTO> getAllFoods();

    //update food

    //delete food
    void deleteFood(String id);
}
