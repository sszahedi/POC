package com.hexaware.poc.service;

import com.hexaware.poc.dao.UserDao;
import com.hexaware.poc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public Collection<User> findAll() {
        return userDao.findAll();
    }
}
