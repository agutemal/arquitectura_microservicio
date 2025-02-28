package com.example.microservicio.services.servicesImplement;
import com.example.microservicio.entities.Transactions;
import com.example.microservicio.entities.Account;
import com.example.microservicio.repository.TransactionsRepository;
import com.example.microservicio.repository.AccountRepository;
import com.example.microservicio.entities.ReportStateAcount;
import com.example.microservicio.services.TransactionsService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionsService{
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Transactions> findAllTransactions(){
        return transactionsRepository.findAll();
    }

    @Override
    public List<ReportStateAcount> findAllReport(LocalDate fechaInicio, LocalDate fechaFin){
        Date startDate = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(fechaFin.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()); // +1 día para incluir toda la fechaFin

        return transactionsRepository.findReportStateAcount(startDate, endDate);
    }
    @Override
    public Transactions createNewTransactions(Transactions newTransactions){
        Transactions newTransactionsCreate;
        BigDecimal currentBalance=null;
        Account updateAccount=accountRepository.findById(newTransactions.getAccount().getId()).orElse(null);
        System.err.println(newTransactions.getAccount().getId());

        if (newTransactions.getTypeTransactions().equalsIgnoreCase("RETIRO")) {
            if (updateAccount.getCurrentBalance().compareTo(newTransactions.getAmount())<0 ) {
                newTransactions.setStateTransactions(false);
                newTransactions.setBalance(updateAccount.getCurrentBalance());
                transactionsRepository.save(newTransactions);
                throw new RuntimeException("Saldo insuficiente");
            } 
            currentBalance=updateAccount.getCurrentBalance().subtract(newTransactions.getAmount());
        } 
        
        if (newTransactions.getTypeTransactions().equalsIgnoreCase("DEPOSITO")) {
            currentBalance=updateAccount.getCurrentBalance().add(newTransactions.getAmount());
        }

        newTransactions.setBalance(currentBalance);
        updateAccount.setCurrentBalance(currentBalance); 
        accountRepository.save(updateAccount);
        newTransactionsCreate=transactionsRepository.save(newTransactions);
        return newTransactionsCreate;
    }

    @Override
    public Transactions updateTransactions(Long id, Transactions updateTransactions){
        Transactions transactionsFindById=transactionsRepository.findById(id).get();
        transactionsFindById.setAmount(updateTransactions.getAmount());
        transactionsFindById.setBalance(updateTransactions.getBalance());
        transactionsFindById.setDateTransactions(updateTransactions.getDateTransactions());
        transactionsFindById.setTypeTransactions(updateTransactions.getTypeTransactions());
        return transactionsRepository.save(transactionsFindById);
    }

    @Override
    public void deleteTransactionsById(Long id){
        transactionsRepository.deleteById(id);
    }

}
