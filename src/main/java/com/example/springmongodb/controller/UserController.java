package com.example.springmongodb.controller;

import com.example.springmongodb.dto.User;
import com.example.springmongodb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        List<User> usersList = userService.getUsersList();
        if (!usersList.isEmpty())
            return ResponseEntity.ok(usersList);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
