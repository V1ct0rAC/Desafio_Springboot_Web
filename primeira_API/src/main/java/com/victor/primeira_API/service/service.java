package com.victor.primeira_API.service;

import org.springframework.stereotype.Service;

@Service

public class service {
    public String hello (String name){
        return "Hello world "+ name;
    }
}
