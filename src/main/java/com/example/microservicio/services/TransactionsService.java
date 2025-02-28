package com.example.microservicio.services;
import java.time.LocalDate;
import java.util.List;


import com.example.microservicio.entities.Transactions;
import com.example.microservicio.entities.ReportStateAcount;


public interface TransactionsService {
    List<Transactions> findAllTransactions();
    Transactions createNewTransactions(Transactions newTransactions);
    Transactions updateTransactions(Long id, Transactions updateTransactions);
    void deleteTransactionsById(Long id);
    List<ReportStateAcount> findAllReport(LocalDate fechaInicio, LocalDate fechaFin);
    
} 