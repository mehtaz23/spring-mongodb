package com.example.springmongodb.controller;

import com.example.springmongodb.dto.User;
import com.example.springmongodb.service.UserService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final MeterRegistry registry;

    public UserController(UserService userService, MeterRegistry registry) {
        this.userService = userService;
        this.registry = registry;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "user.time", description = "Time taken to return users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> usersList = userService.getUsersList();
        if (!usersList.isEmpty())
            return ResponseEntity.ok(usersList);
        //registry.counter("greetings.counter").increment();
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
