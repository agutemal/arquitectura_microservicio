package com.example.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservicio.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
