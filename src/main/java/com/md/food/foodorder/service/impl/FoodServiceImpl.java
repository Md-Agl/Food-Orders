package com.md.food.foodorder.service.impl;

import com.md.food.foodorder.dto.FoodGeneralDTO;
import com.md.food.foodorder.entity.Food;
import com.md.food.foodorder.helper.FileHelper;
import com.md.food.foodorder.repo.FoodRepo;
import com.md.food.foodorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepo foodRepo;
    private final FileHelper fileHelper;

    @Override
    public FoodGeneralDTO addFood(FoodGeneralDTO request, MultipartFile file) {
        Food food = request.toEntity();
        food.setImageUrl(fileHelper.uploadFile(file));

        //save to db
        food = foodRepo.save(food);
        return FoodGeneralDTO.fromEntity(food);
    }

    @Override
    public FoodGeneralDTO getFoodById(String id) {
        Food food = foodRepo.findById(id).orElseThrow(() -> new RuntimeException("Food not found with Id:" + id));
        return FoodGeneralDTO.fromEntity(food);
    }

    @Override
    public List<FoodGeneralDTO> getAllFoods() {
        return foodRepo.findAll().stream()
                .map(FoodGeneralDTO::fromEntity)
                .toList();
    }

    @Override
    public void deleteFood(String id) {
        FoodGeneralDTO existingFood = getFoodById(id);
        boolean isDeleted = fileHelper.deleteUploadFile(existingFood.getImageUrl());
        if (isDeleted){
            foodRepo.deleteById(id);
        }
    }
}
