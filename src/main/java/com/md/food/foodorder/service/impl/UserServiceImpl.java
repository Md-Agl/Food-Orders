package com.md.food.foodorder.service.impl;

import com.md.food.foodorder.dto.UserRequest;
import com.md.food.foodorder.dto.UserResponse;
import com.md.food.foodorder.entity.Users;
import com.md.food.foodorder.repo.UserRepo;
import com.md.food.foodorder.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public UserResponse registerUser(UserRequest request) {
        Users user = UserRequest.toEntity(request);
        user = userRepo.save(user);
        return UserResponse.fromEntity(user);
    }
}
