package com.ntpoc.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ntpoc/user/details")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<UserResponse> getAll() {
        log.info("getAll : UserController");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getOne(@PathVariable Integer userId) {
        log.info("getOne : UserController");
        return new ResponseEntity<>(userService.findOne(userId), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateOne(@PathVariable Integer userId, @RequestBody UserRequest request) {
        log.info("updateOne : UserController");
        return new ResponseEntity<>(userService.updateOne(userId, request), HttpStatus.OK);
    }
}
