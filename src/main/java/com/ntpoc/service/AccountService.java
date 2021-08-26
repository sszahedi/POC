package com.ntpoc.service;

import com.ntpoc.dao.AccountDao;
import com.ntpoc.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        log.info("findAll : AccountService");
        return accountDao.findAll();
    }

    public Account findOne(Integer accountNumber) {
        log.info("findOne : AccountService");
        return accountDao.findById(accountNumber).orElseThrow();
    }
}
