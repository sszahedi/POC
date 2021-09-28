package com.ntpoc.balance;

import lombok.Data;

import java.util.List;

@Data
public class BalanceResponse {

    private final List<Balance> balances;
}
