package com.ntpoc.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private Integer accountNumber;

    @Column(name = "description")
    private String accountDesc;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "label")
    @JsonIgnore
    private String label;
}
