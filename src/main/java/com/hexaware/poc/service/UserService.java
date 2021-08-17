package com.hexaware.poc.service;

import com.hexaware.poc.dao.UserDao;
import com.hexaware.poc.entity.User;
import com.hexaware.poc.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(Integer userId) {
        return userDao.findById(userId).orElseThrow(
                () -> new NotFoundException(
                        "user with id " + userId + " not found"));
    }
}
