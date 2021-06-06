package fr.moveinmed.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessionalController {

    @RequestMapping("/")
    public String index() {
        return "Le controller à été bien créé";
    }
}
