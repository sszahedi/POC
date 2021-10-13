package com.ntpoc.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ntpoc/accounts")
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping()
    public ResponseEntity<Map<String, Account>> getAll() {
        log.info("getAll : AccountController");
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getOne(@PathVariable Integer accountNumber) {
        log.info("getOne : AccountController");
        return new ResponseEntity<>(accountService.findOne(accountNumber), HttpStatus.OK);
    }
}
