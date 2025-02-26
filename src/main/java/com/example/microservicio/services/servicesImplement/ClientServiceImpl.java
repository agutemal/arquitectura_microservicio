package com.example.microservicio.services.servicesImplement;

import com.example.microservicio.services.ClientService;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.microservicio.repository.ClientRepository;
import com.example.microservicio.entities.Client;

@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }

    @Override
    public Client createNewClient(Client newClient){
        Client newClientCreate=clientRepository.save(newClient);
        return newClientCreate;
    }

    @Override
    public Client updateClient(Long id, Client updateClient){
        Client clientFindById=clientRepository.findById(id).get();
        clientFindById.setAddress(updateClient.getAddress());
        clientFindById.setAge(updateClient.getAge());
        clientFindById.setCellPhone(updateClient.getCellPhone());
        clientFindById.setDni(updateClient.getDni());
        clientFindById.setGender(updateClient.getGender());
        clientFindById.setName(updateClient.getName());
        clientFindById.setPassWord(updateClient.getPassWord());
        clientFindById.setState(updateClient.getState());

        return clientRepository.save(clientFindById);
    }

    @Override
    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
}
