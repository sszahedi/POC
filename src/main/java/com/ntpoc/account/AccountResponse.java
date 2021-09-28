package com.ntpoc.account;

import lombok.Data;

import java.util.List;

@Data
public class AccountResponse {

    private final List<Account> accounts;
}
