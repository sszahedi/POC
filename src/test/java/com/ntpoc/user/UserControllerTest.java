package com.ntpoc.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void canGetAllAccounts() throws Exception {
        User userOne = new User(
                1,
                "John",
                "Smith",
                "1 Address",
                5555555555L,
                "johnsmith@test.com"
        );
        User userTwo = new User(
                2,
                "Jane",
                "Johnson",
                "2 Address",
                2222222222L,
                "jane@test.com"
        );
        userRepository.saveAll(List.of(userOne, userTwo));

        MvcResult mvcResult = mockMvc.perform(get("/ntpoc/user/details"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult
                .getResponse()
                .getContentAsString();

        List<User> users = objectMapper.readValue(
                contentAsString,
                new TypeReference<>() {}
        );

        assertThat(users)
                .hasSize(2)
                .isEqualTo(List.of(userOne, userTwo));
    }

    @Test
    void canGetOneUser() throws Exception {
        int userId = 1;
        User userOne = new User(
                userId,
                "John",
                "Smith",
                "1 Address",
                5555555555L,
                "johnsmith@test.com"
        );
        userRepository.save(userOne);

        MvcResult mvcResult = mockMvc.perform(get("/ntpoc/user/details/" + userId))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult
                .getResponse()
                .getContentAsString();

        User result = objectMapper.readValue(
                contentAsString,
                new TypeReference<>() {}
        );

        assertThat(result)
                .isEqualTo(userOne);
    }

    @Test
    void willThrowWhenGettingUserThatDoesNotExist() throws Exception {

        int userId = 100;

        String error = mockMvc.perform(get("/ntpoc/user/details/" + userId))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResolvedException()
                .getMessage();

        assertThat(error)
                .contains("user with id " + userId + " not found");
    }

    @Test
    void canUpdateUser() throws Exception {

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

        userRepository.save(user);

        ResultActions resultActions = mockMvc.perform(patch("/ntpoc/user/details/" + userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        User result = userRepository.findById(1).get();

        assertThat(result).isEqualTo(expected);
    }
}