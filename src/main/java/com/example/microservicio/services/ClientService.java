package com.example.microservicio.services;
import com.example.microservicio.entities.Client;
import java.util.List;

public interface ClientService {
    List<Client> findAllClient();
    Client createNewClient(Client newClient);
    Client updateClient(Long id, Client updateClient);
    void deleteClientById(Long id);
}
