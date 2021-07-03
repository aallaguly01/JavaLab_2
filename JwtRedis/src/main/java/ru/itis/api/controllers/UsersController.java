package ru.itis.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.services.UsersService;


@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/users/{user-id}/block")
    public ResponseEntity<?> blockUser(@PathVariable("user-id") Long userId) {
        usersService.blockUser(userId);
        return ResponseEntity.ok().build();
    }
}
