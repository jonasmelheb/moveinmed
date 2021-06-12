package fr.moveinmed.services;

import fr.moveinmed.models.Professional;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProfessionalService {

    void addProfessional(Professional professional);

    List<Professional> getListProfessionals();

    Professional findProfessionalById(Long searchedId);

    List<Professional> findAllByFirstNameContaining(String searchedFirstName);

    List<Professional> findAllSearch(Specification<Professional> spec);

    void deleteProfessional(Long id);

    void updateProfessional(Professional professional, Long id);
}
