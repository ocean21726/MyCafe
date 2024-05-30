package com.example.mycafe.controller;

import com.example.mycafe.entity.User;
import com.example.mycafe.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {
    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/user")
    List<User> all() {
        return userRepository.findAll();
    }
}
