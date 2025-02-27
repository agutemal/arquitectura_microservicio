package com.example.microservicio.controllers;
import com.example.microservicio.services.TransactionsService;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Date;

import com.example.microservicio.entities.Transactions;


@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/listAllTransactions")
    public List<Transactions> findAllTransactions() {
        return transactionsService.findAllTransactions();
    }

    @PostMapping("/createNewTransactions")
    public ResponseEntity<Object> createNewAccount(@RequestBody Transactions newTransactions) {
        newTransactions.setDateTransactions(new Date());
        try {
            Transactions newTransactionsCreate=transactionsService.createNewTransactions(newTransactions);
            return ResponseEntity.ok(newTransactionsCreate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error interno en el servidor");
        }
    }
    
    @PutMapping("/updateTransactions/{id}")
    public Transactions updateClient(@PathVariable Long id,  @RequestBody(required = false) Transactions updateTransactions) {
        Transactions newUpdateTransactions=transactionsService.updateTransactions(id, updateTransactions);
        return newUpdateTransactions;
    }

    @DeleteMapping("/deleteTransactions/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id){
        transactionsService.deleteTransactionsById(id);
        return ResponseEntity.ok("Movimientos eliminado");
    }
    
}
