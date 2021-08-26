package com.ntpoc.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name ="balances")
@Data
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="account_number")
    private Integer accountNumber;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "balance_timestamp")
    private LocalDateTime balanceTimestamp;
}
