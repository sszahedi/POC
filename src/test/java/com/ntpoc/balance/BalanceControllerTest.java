package com.ntpoc.balance;

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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
@AutoConfigureMockMvc
class BalanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BalanceRepository balanceRepository;

    @Test
    void canGetAllBalances() throws Exception {
        Balance balanceOne = new Balance(1, 111111, new BigDecimal("100.00"), LocalDateTime.now(), "balanceOne");
        Balance balanceTwo = new Balance(2, 222222, new BigDecimal("200.00"), LocalDateTime.now(), "balanceTwo");
        balanceRepository.saveAll(Arrays.asList(balanceOne, balanceTwo));

        MvcResult getBalancesResult = mockMvc.perform(get("/ntpoc/balances")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = getBalancesResult
                .getResponse()
                .getContentAsString();

        Map<String, Balance> balances = objectMapper.readValue(
                contentAsString,
                new TypeReference<Map<String, Balance>>() {}
        );

        assertThat(balances.values())
                .hasSize(2)
                .usingElementComparatorIgnoringFields("balanceTimestamp", "label")
                .contains(balanceOne, balanceTwo);
    }

    @Test
    void canGetOneBalance() throws Exception {

        int balanceNumber = 1;
        Balance balanceOne = new Balance(1, 111111, new BigDecimal("100.00"), LocalDateTime.now(), null);
        balanceRepository.save(balanceOne);

        MvcResult getBalanceResult = mockMvc.perform(get("/ntpoc/balances/" + balanceNumber)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = getBalanceResult
                .getResponse()
                .getContentAsString();

        Balance result = objectMapper.readValue(
                contentAsString,
                new TypeReference<Balance>() {}
        );

        assertThat(result).usingRecursiveComparison()
                .ignoringFields("balanceTimestamp")
                .isEqualTo(balanceOne);
    }

    @Test
    void willThrowWhenGettingBalanceThatDoesNotExist() throws Exception {

        int balanceNumber = 111111;

        String error = mockMvc.perform(get("/ntpoc/balances/" + balanceNumber)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResolvedException()
                .getMessage();

        assertThat(error)
                .contains("balance with id " + balanceNumber + " not found");
    }

}