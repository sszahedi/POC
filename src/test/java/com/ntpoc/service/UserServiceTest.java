package com.ntpoc.service;

import com.ntpoc.user.UserRepository;
import com.ntpoc.user.User;
import com.ntpoc.user.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {

    @Autowired
    private UserRepository userDao;

    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userDao);
    }

    @AfterEach
    void tearDown() {
        userDao.deleteAll();
    }

    //@Test
    void findAll() {
        List<User> users = underTest.findAll();

        assertEquals(10, users.size());
    }

    //@Test
//    void findOne() {
////        User user = new User(
//                11,
//                "John",
//                "Doe"
//        );
//
//        userDao.save(user);
//
//        User actual = underTest.findOne(11);
//
//        assertEquals(11, actual.getId());
//        assertEquals("John", actual.getFirstName());
//        assertEquals("Doe", actual.getLastName());
//    }
}