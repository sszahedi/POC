package com.ntpoc.balance;

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
public class BalanceService {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Map<String, Balance> findAll() {
        log.info("findAll : BalanceService");
        return ListToMap(balanceRepository.findAll());
    }

    public Balance findOne(Integer id) {
        log.info("findOne : BalanceService");
        return balanceRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "balance with id " + id + " not found"
        ));
    }

    private Map<String, Balance> ListToMap(List<Balance> list) {
        Map<String, Balance> map = list.stream()
                .collect(Collectors.toMap(Balance::getLabel, Function.identity()));
        return map;
    }
}
