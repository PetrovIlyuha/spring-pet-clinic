package com.softomore.petclinic.controllers;

import com.softomore.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index", "/vets/index.html"})
    public String listVets(Model model) {
        System.out.println(vetService.findAll());
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
