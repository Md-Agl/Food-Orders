package com.md.food.foodorder.service;

import com.md.food.foodorder.dto.UserRequest;
import com.md.food.foodorder.dto.UserResponse;

public interface UserService {

    //register user
    UserResponse registerUser(UserRequest request);

}
