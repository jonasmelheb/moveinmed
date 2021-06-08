package fr.moveinmed.services;

import fr.moveinmed.models.Professional;

import java.util.List;

public interface ProfessionalService {

    void addProfessional(Professional professional);

    List<Professional> getListProfessionals();

    Professional findProfessionalById(Long searchedId);

    List<Professional> findAllByFirstNameContaining(String searchedFirstName);

    void deleteProfessional(Long id);

    void updateProfessional(Professional professional);
}
