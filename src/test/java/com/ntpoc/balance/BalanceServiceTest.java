package com.ntpoc.balance;

import com.ntpoc.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BalanceServiceTest {

    @Mock
    private BalanceRepository balanceRepository;
    private BalanceService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BalanceService(balanceRepository);
    }

    @Test
    void canGetAllBalances() {
        // when
        underTest.findAll();

        // then
        verify(balanceRepository).findAll();
    }

    @Test
    void canGetOneBalance() {
        // given
        Integer balanceId = 1;
        Balance balance = new Balance(
                balanceId,
                111111,
                new BigDecimal("100.00"),
                LocalDateTime.now(),
                "balanceOne");
        given(balanceRepository.findById(balanceId)).willReturn(Optional.of(balance));

        // when
        Balance result = underTest.findOne(balanceId);

        // then
        assertThat(result).isEqualTo(balance);
    }

    @Test
    void willThrowWhenBalanceNotFound() {
        // given
        Integer balanceId = 1;
        given(balanceRepository.findById(balanceId)).willReturn(Optional.empty());

        // when
        // then
        assertThatThrownBy(() -> underTest.findOne(balanceId))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("balance with id " + balanceId + " not found");
    }
}