package com.example.microservicio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;

import java.util.List;
import com.example.microservicio.entities.Transactions;
import com.example.microservicio.entities.ReportStateAcount;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

    @Query("""
        SELECT new com.example.microservicio.entities.ReportStateAcount(
            t.dateTransactions,
            p.name,
            a.accountNumber,
            a.accountType,
            a.openingBalance,
            t.stateTransactions,
            t.typeTransactions,
            t.amount,
            t.balance
        )
        FROM Transactions t 
        INNER JOIN Account a ON t.account.id = a.id 
        INNER JOIN Person p ON p.id = a.person.id
         WHERE t.dateTransactions >= :startDate 
        AND t.dateTransactions < :endDate
   """)
   List<ReportStateAcount> findReportStateAcount(@Param("startDate") Date  startDate, @Param("endDate") Date  endDate);
    
}
