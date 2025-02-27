package com.example.microservicio.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateTransactions;       //Fecha movimiento
    private String typeTransactions;     //Tipo movimiento 
    @NotNull
    private BigDecimal balance;          //valor
    @NotNull          
    private BigDecimal amount;           //saldo

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
