package com.ntpoc.user;

import com.ntpoc.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }

    @Test
    void canGetAllUsers() {
        // when
        underTest.findAll();

        // then
        verify(userRepository).findAll();
    }

    @Test
    void canGetOneUser() {
        // given
        Integer userId = 1;
        User user = new User(
                1,
                "John",
                "Smith",
                "Address",
                5555555555L,
                "johnsmith@test.com"
        );
        given(userRepository.findById(userId)).willReturn(Optional.of(user));

        // when
        User result = underTest.findOne(userId);

        // then
        assertThat(result).isEqualTo(user);
    }

    @Test
    void willThrowWhenUserNotFound() {
        // given
        Integer userId = 1;
        given(userRepository.findById(userId)).willReturn(Optional.empty());

        // when
        // then
        assertThatThrownBy(() -> underTest.findOne(userId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("user with id " + userId + " not found");
    }

    @Test
    void canUpdateUser() {
        // given
        Integer userId = 1;
        User user = new User(
                1,
                "John",
                "Smith",
                "Address",
                5555555555L,
                "johnsmith@test.com"
        );
        UserRequest request = new UserRequest(
                "Updated address",
                1111111111L,
                "updatedEmail@test.com"
        );
        User expected = new User(
                1,
                "John",
                "Smith",
                "Updated address",
                1111111111L,
                "updatedEmail@test.com"
        );
        given(userRepository.findById(userId)).willReturn(Optional.of(user));

        // when
        User result = underTest.updateOne(1, request);

        // then
        assertThat(result).isEqualTo(expected);
    }
}