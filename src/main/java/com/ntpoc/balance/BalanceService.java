package com.ntpoc.balance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BalanceService {

    private final BalanceRepository balanceDao;

    @Autowired
    public BalanceService(BalanceRepository balanceDao) {
        this.balanceDao = balanceDao;
    }

    public List<Balance> findAll() {
        log.info("findAll : BalanceService");
        return balanceDao.findAll();
    }

    public Balance findOne(Integer id) {
        log.info("findOne : BalanceService");
        return balanceDao.findById(id).orElseThrow();
    }
}
