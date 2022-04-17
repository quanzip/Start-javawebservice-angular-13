package com.example.backend.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HomeController {

    @GetMapping(value = {"/home", "/"})
    public String showPet() {
        return "home";
    }
}
