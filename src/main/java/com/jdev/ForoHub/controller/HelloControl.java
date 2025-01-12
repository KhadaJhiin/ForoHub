package com.jdev.ForoHub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControl {
    @GetMapping
    public String helloWorld(){
        return "Hello world neverland";
    }

}
