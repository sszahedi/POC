package com.ntpoc.account;

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
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    private AccountService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AccountService(accountRepository);
    }

    @Test
    void canGetAllAccounts() {
        // when
        underTest.findAll();

        // then
        verify(accountRepository).findAll();
    }

    @Test
    void canGetOneAccount() {
        // given
        Integer accountNumber = 111111;
        Account account = new Account(accountNumber, "Checking", 10000L);
        given(accountRepository.findById(accountNumber)).willReturn(Optional.of(account));

        // when
        Account result = underTest.findOne(accountNumber);

        // then
        assertThat(result).isEqualTo(account);
    }

    @Test
    void willThrowWhenAccountNotFound() {
        // given
        Integer accountNumber = 111111;
        given(accountRepository.findById(accountNumber)).willReturn(Optional.empty());

        // when
        // then
        assertThatThrownBy(() -> underTest.findOne(accountNumber))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("account with accountNumber " + accountNumber + " not found.");
    }
}