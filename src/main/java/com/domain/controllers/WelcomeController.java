package com.domain.controllers;

import com.domain.services.HeavyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/welcome")
public class WelcomeController {

    @Autowired
    private HeavyService heavyService;
    

    @GetMapping("/heavyservice")
    public String getData(){
        return heavyService.getSomeData();
    }

    @GetMapping
    public String welcome(){
        return "Welcome to Spring Boot Rest API";
    }
    
}
