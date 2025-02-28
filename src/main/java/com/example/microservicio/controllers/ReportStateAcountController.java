package com.example.microservicio.controllers;

import java.time.LocalDate;
import java.util.List;
import com.example.microservicio.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.microservicio.entities.ReportStateAcount;

@RestController
@Validated
public class ReportStateAcountController {
    @Autowired
    private TransactionsService transactionsService;

    @GetMapping("/reportStateAcount")
    public List<ReportStateAcount> finAllReportStateAcount(
        @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio,
        @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {
            System.err.println(fechaInicio);
            System.err.println(fechaFin);
        return transactionsService.findAllReport(fechaInicio,fechaFin);
    }
    
}
