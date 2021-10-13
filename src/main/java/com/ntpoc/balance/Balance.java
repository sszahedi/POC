package com.ntpoc.balance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name ="balances")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "label")
    @JsonIgnore
    private String label;
}
