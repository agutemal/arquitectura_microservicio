package com.example.microservicio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.microservicio.entities.Account;
import com.example.microservicio.services.AcountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/accounts")
public class AcountController {
    @Autowired
    private AcountService acountService;

    @GetMapping("/listAllAccounts")
    public List<Account> findAllAccount() {
        return acountService.findAllAccount();
    }

    @PostMapping("/createNewAccount")
    public ResponseEntity<Object> createNewAccount(@RequestBody Account newAccount) {
        try {
            Account newAccountCreate=acountService.createNewAccount(newAccount);
            return ResponseEntity.ok(newAccountCreate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error interno en el servidor");
        }
    }

    @PutMapping("/updateAccount/{id}")
    public Account updateAccount(@PathVariable Long id,  @RequestBody(required = false) Account updateAccount) {
        Account newUpdateAccount=acountService.updateAccount(id, updateAccount);
        return newUpdateAccount;
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id){
        acountService.deleteAccountById(id);
        return ResponseEntity.ok("Cuenta eliminada");
    }
    
}

