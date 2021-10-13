package com.ntpoc.account;

import com.ntpoc.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Map<String, Account> findAll() {
        log.info("findAll : AccountService");
        return ListToMap(accountRepository.findAll());
    }

    public Account findOne(Integer accountNumber) {
        log.info("findOne : AccountService");
        return accountRepository.findById(accountNumber).orElseThrow(
                () -> new NotFoundException("account with accountNumber " + accountNumber + " not found."));
    }

    private Map<String, Account> ListToMap(List<Account> list) {
        Map<String, Account> map = list.stream()
                .collect(Collectors.toMap(Account::getLabel, Function.identity()));
        return map;
    }
}
