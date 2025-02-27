package com.example.microservicio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservicio.entities.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
    
}
