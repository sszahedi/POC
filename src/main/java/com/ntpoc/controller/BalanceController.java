package com.ntpoc.controller;

import com.ntpoc.entity.Balance;
import com.ntpoc.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ntpoc/balances")
@Slf4j
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @GetMapping()
    public ResponseEntity<List<Balance>> getAll() {
        log.info("getAll : BalanceController");
        return new ResponseEntity<>(balanceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Balance> getOne(@PathVariable Integer id) {
        log.info("getOne : BalanceController");
        return new ResponseEntity<>(balanceService.findOne(id), HttpStatus.OK);
    }
}
