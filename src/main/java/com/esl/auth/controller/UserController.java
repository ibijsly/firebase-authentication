package com.esl.auth.controller;

import com.esl.auth.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public void addUser() throws FirebaseAuthException {
        userService.addUser();
    }
}
