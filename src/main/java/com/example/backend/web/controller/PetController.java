package com.example.backend.web.controller;

import com.example.backend.entity.Pet;
import io.swagger.annotations.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class PetController {

    @GetMapping(value = "/pet")
    public String showPet(Model model){
        model.addAttribute("mypet", new Pet(6,5,"Join"));
        return "pet";
    }
}
