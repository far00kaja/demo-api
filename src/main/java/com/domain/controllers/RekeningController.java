package com.domain.controllers;

import com.domain.dto.TransferRequest;
import com.domain.models.entities.Rekening;
import com.domain.services.RekeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rekening")
public class RekeningController {
    
    @Autowired
    private RekeningService service;

    @PostMapping
    public Rekening create(@RequestBody Rekening rekening){
        return service.create(rekening);
    }

    @GetMapping
    public Iterable<Rekening> findAll(){
        return service.findAll();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transfer){
        System.out.println("tester");
        System.out.println("tester2");
        System.out.println(transfer.getNorek1());
        System.out.println(transfer.getNorek2());
        System.out.println(transfer.getAmount());
        service.transfer(transfer.getNorek1(), transfer.getNorek2(), transfer.getAmount());
    }
    
}
