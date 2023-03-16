package com.example.springmongodb.repository;

import com.example.springmongodb.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
