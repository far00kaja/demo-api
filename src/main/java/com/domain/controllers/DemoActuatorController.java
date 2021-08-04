package com.domain.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/actuator")
public class DemoActuatorController {

    @GetMapping("/first")
    public String myFirstEndPoint(){
        return "This my first end point";
    }

    @GetMapping("/second")
    public String mySecondEndPoint(){
        return "this my second endpoint";
    }
    

}
