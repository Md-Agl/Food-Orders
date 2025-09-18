package com.md.food.foodorder.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.md.food.foodorder.dto.FoodGeneralDTO;
import com.md.food.foodorder.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //add food
    @PostMapping
    public ResponseEntity<?> addFood(@RequestPart("food") String foodString, @RequestPart("file") MultipartFile file)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        FoodGeneralDTO request = objectMapper.readValue(foodString, FoodGeneralDTO.class);

        return new ResponseEntity<>(this.foodService.addFood(request, file), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable String id) {
        return ResponseEntity.ok(this.foodService.getFoodById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllFoods() {
        return ResponseEntity.ok(this.foodService.getAllFoods());
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteFood(@PathVariable String id) {
        this.foodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
