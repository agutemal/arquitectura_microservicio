package com.example.microservicio.services.servicesImplement;
import com.example.microservicio.entities.Client;
import com.example.microservicio.entities.Transactions;
import com.example.microservicio.repository.TransactionsRepository;
import com.example.microservicio.services.TransactionsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionsService{
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public List<Transactions> findAllTransactions(){
        return transactionsRepository.findAll();
    }
    
    @Override
    public Transactions createNewTransactions(Transactions newTransactions){
        Transactions newClientCreate=transactionsRepository.save(newTransactions);
        return newClientCreate;
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
