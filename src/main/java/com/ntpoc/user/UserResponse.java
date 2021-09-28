package com.ntpoc.user;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private final List<User> users;
}
