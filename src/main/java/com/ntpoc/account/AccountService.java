package com.ntpoc.account;

import com.ntpoc.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse findAll() {
        log.info("findAll : AccountService");
        return new AccountResponse(accountRepository.findAll());
    }

    public Account findOne(Integer accountNumber) {
        log.info("findOne : AccountService");
        return accountRepository.findById(accountNumber).orElseThrow(
                () -> new NotFoundException("account with accountNumber " + accountNumber + " not found."));
    }
}
