package com.example.Ejercicios456.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hola(){
        return "Ejercicio API REST Laptops";
    }
}
