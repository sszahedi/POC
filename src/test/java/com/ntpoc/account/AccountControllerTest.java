package com.ntpoc.account;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void canGetAllAccounts() throws Exception {
        Account accountOne = new Account(111111, "Checking", 10000L, "accountOne");
        Account accountTwo = new Account(222222, "Savings", 10000L, "accountTwo");
        accountRepository.saveAll(Arrays.asList(accountOne, accountTwo));

        MvcResult getAccountsResult = mockMvc.perform(get("/ntpoc/accounts"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = getAccountsResult
                .getResponse()
                .getContentAsString();

        Map<String, Account> accounts = objectMapper.readValue(
                contentAsString,
                new TypeReference<Map<String, Account>>() {}
        );

        assertThat(accounts.values())
                .hasSize(2)
                .usingElementComparatorIgnoringFields("label")
                .contains(accountOne, accountTwo);
    }

    @Test
    void canGetOneAccount() throws Exception {

        int accountNumber = 111111;
        Account accountOne = new Account(accountNumber, "Checking", 10000L, null);
        accountRepository.save(accountOne);

        MvcResult getAccountResult = mockMvc.perform(get("/ntpoc/accounts/" + accountNumber))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = getAccountResult
                .getResponse()
                .getContentAsString();

        Account result = objectMapper.readValue(
                contentAsString,
                new TypeReference<Account>() {}
        );

        assertThat(result)
                .isEqualTo(accountOne);
    }

    @Test
    void willThrowWhenGettingAccountThatDoesNotExist() throws Exception {

        int accountNumber = 33333;

        String error = mockMvc.perform(get("/ntpoc/accounts/" + accountNumber))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResolvedException()
                .getMessage();

        assertThat(error)
                .contains("account with accountNumber " + accountNumber + " not found.");
    }

}