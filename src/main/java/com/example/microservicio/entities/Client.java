package com.example.microservicio.entities;


import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client extends Person{
    private String passWord;
    private String state;
}
