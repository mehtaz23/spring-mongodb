package com.example.springmongodb.service;

import com.example.springmongodb.dto.User;
import com.example.springmongodb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersList() {
       return userRepository.findAll();
    }

    public void createUser(User user) {
        User userToCreate = new User();
        userToCreate.setName(user.getName());
        userToCreate.setEmail(user.getEmail());
        userToCreate.setPhone(user.getPhone());
        userRepository.save(userToCreate);
    }
}
