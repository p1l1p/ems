package com.ems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }
}
