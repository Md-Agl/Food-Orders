package com.md.food.foodorder.repo;

import com.md.food.foodorder.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<Users, String> {

    Optional<Users> findByEmail(String email);
}
