package fr.moveinmed.controllers;

import fr.moveinmed.models.Professional;
import fr.moveinmed.services.ProfessionalService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/professionals")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professional> addProfessional(@Valid @RequestBody Professional professional) {
        professionalService.addProfessional(professional);
        return new ResponseEntity<>(professional, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professional>> getAllProfessional(@RequestParam(required = false) String name) {
        List<Professional> professionals = professionalService.getListProfessionals();
        if (professionals != null) {
            return new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professional> getProfessionalById(@PathVariable("id") long id) {
        Professional professional = professionalService.findProfessionalById(id);
        if (professional != null) {
            return new ResponseEntity<>(professional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Professional>> getProfessionalByName(@Param("name") String name) {
        List<Professional> professionals = professionalService.findAllByFirstNameContaining(name);
        if (professionals != null) {
            return new ResponseEntity<>(professionals, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable("id") Long id, @RequestBody Professional professional) {
        if (professionalService.findProfessionalById(id) != null) {
            professionalService.updateProfessional(professional, id);
            return new ResponseEntity<>(professional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProfessional(@PathVariable("id") Long id) {
        Professional professional = professionalService.findProfessionalById(id);
        if (professional != null) {
            professionalService.deleteProfessional(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
