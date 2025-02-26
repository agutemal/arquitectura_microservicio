package com.example.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.microservicio.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
