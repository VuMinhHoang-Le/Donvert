package com.donvert.user_microservice.repository;

import com.donvert.user_microservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
