package com.example.microservicio.services;
import java.util.List;


import com.example.microservicio.entities.Transactions;


public interface TransactionsService {
    List<Transactions> findAllTransactions();
    Transactions createNewTransactions(Transactions newTransactions);
    Transactions updateTransactions(Long id, Transactions updateTransactions);
    void deleteTransactionsById(Long id);
    
} 