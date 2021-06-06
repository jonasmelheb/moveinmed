package fr.moveinmed.controllers;

import fr.moveinmed.models.Professional;
import fr.moveinmed.services.ProfessionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfessionalController {

    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @GetMapping("/professionals")
    public ResponseEntity getAllProfessional() {
        List<Professional> professionals = professionalService.getListProfessionals();
        if (professionals != null) {
            return new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
