package com.example.microservicio.entities;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ReportStateAcount {

    private Date dateTransactions;
    private String name;
    private String accountNumber;
    private String accountType;
    private BigDecimal openingBalance;
    private boolean stateTransactions;
    private String typeTransactions;
    private BigDecimal amount;
    private BigDecimal balance;
    
}
