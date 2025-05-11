package com.limbo.Demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet() {
        return "Hello via my website!";
    }

    @RequestMapping("/about")
    public String about(){
        return "We created our company in 2025";
    }
}
