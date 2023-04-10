package com.jaubass.cursospringboot.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String saludo () {
        return "Hello World! with Spring by Jaubass!";

    }
}
