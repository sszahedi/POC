package com.hexaware.poc.controller;

import com.hexaware.poc.entity.User;
import com.hexaware.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Collection<User>> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
