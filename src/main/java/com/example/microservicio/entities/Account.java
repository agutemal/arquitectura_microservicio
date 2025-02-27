package com.example.microservicio.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;          //numero cuenta 
    private String accountType;            //tipo cuenta
    private BigDecimal openingBalance;     //saldo inicial
    private String accountState;           //estado


    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
