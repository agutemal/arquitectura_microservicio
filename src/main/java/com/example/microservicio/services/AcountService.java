package com.example.microservicio.services;

import java.util.List;

import com.example.microservicio.entities.Account;

public interface AcountService {
   List <Account> findAllAccount();
   Account createNewAccount(Account newAccount);
   Account updateAccount(Long id, Account updateAccount);
   void deleteAccountById(Long id);
}
