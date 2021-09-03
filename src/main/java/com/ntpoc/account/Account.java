package com.ntpoc.account;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    private Integer accountNumber;

    @Column(name = "description")
    private String accountDesc;

    @Column(name = "balance")
    private Long balance;
}
