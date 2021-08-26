package com.ntpoc.service;

import com.ntpoc.dao.UserDao;
import com.ntpoc.entity.User;
import com.ntpoc.entity.UserRequest;
import com.ntpoc.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        log.info("findAll : UserService");
        return userDao.findAll();
    }

    public User findOne(Integer userId) {
        log.info("findOne : UserService");
        return userDao.findById(userId).orElseThrow(
                () -> new NotFoundException(
                        "user with id " + userId + " not found"));
    }

    public User updateOne(Integer userId, UserRequest request) {
        log.info("updateOne : UserService");
        User user = findOne(userId);

        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        return userDao.save(user);
    }
}
