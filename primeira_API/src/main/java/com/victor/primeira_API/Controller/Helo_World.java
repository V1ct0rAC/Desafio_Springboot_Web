package com.victor.primeira_API.Controller;

import com.victor.primeira_API.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Helo_World")
public class Helo_World {

    private service helloservice;
    public Helo_World(service helloservice){
        this.helloservice = helloservice;

    }
    @GetMapping
    public String heloWorld(){
                return helloservice.hello("Victor");

    }

}
