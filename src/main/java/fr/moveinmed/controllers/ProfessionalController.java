package fr.moveinmed.controllers;

import fr.moveinmed.models.Profession;
import fr.moveinmed.models.Professional;
import fr.moveinmed.services.ProfessionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addProfessional(@RequestBody Professional professional) {
        professionalService.addProfessional(professional);
        return new ResponseEntity<>(professional, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllProfessional(@RequestParam(required = false) String firstName, String lastName) {
        Profession[] professions = Profession.values();
        if (StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            List<Professional> professionals = professionalService.getListProfessionals();
            if (professionals != null) {
                return new ResponseEntity<>(professionals, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<Professional> professionals = professionalService.findAllByFirstNameContaining(firstName);
        return new ResponseEntity<>(professionals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProfessionalById(@PathVariable("id") long id) {
        Professional professional = professionalService.findProfessionalById(id);
        if (professional != null) {
            return new ResponseEntity<>(professional, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity updateProfessional(@RequestBody Professional professional) {
        if (professionalService.findProfessionalById(professional.getId()) != null) {
            professionalService.updateProfessional(professional);
            return new ResponseEntity<>(professional, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProfessional(@PathVariable("id") Long id) {
        Professional professional = professionalService.findProfessionalById(id);
        if (professional != null) {
            professionalService.deleteProfessional(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
