package com.example.microservicio.controllers;
import com.example.microservicio.services.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservicio.entities.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("listAllClients")
    public List<Client> findAllClients() {
        return clientService.findAllClient();
    }

    @PostMapping("/createNewClient")
    public ResponseEntity<Object> createNewAccount(@RequestBody Client newClient) {
        try {
            Client newClientCreate=clientService.createNewClient(newClient);
            return ResponseEntity.ok(newClientCreate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error interno en el servidor");
        }
    }

    @PutMapping("/updateClient/{id}")
    public Client updateClient(@PathVariable Long id,  @RequestBody(required = false) Client updateClient) {
        Client newUpdateClient=clientService.updateClient(id, updateClient);
        return newUpdateClient;
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok("Cliente eliminado");
    }
    
}
