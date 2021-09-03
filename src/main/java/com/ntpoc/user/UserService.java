package com.ntpoc.user;

import com.ntpoc.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        log.info("findAll : UserService");
        return userRepository.findAll();
    }

    public User findOne(Integer userId) {
        log.info("findOne : UserService");
        return userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(
                        "user with id " + userId + " not found"));
    }

    @Transactional
    public User updateOne(Integer userId, UserRequest request) {
        log.info("updateOne : UserService");
        User user = findOne(userId);

        if (StringUtils.isNotBlank(request.getAddress()) &&
            !Objects.equals(user.getAddress(), request.getAddress())) {
            user.setAddress(request.getAddress());
        }

        if (request.getPhoneNumber() != null &&
            !Objects.equals(user.getPhoneNumber(), request.getPhoneNumber())) {
            user.setPhoneNumber(request.getPhoneNumber());
        }

        if (StringUtils.isNotBlank(request.getEmail()) &&
                !Objects.equals(user.getEmail(), request.getEmail())) {
            user.setEmail(request.getEmail());
        }

        return user;
    }
}
