package fr.moveinmed.services;

import fr.moveinmed.models.Professional;
import fr.moveinmed.repositories.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService{

    private final ProfessionalRepository professionalRepository;

    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    @Override
    public void addProfessional(Professional professional) {
        professionalRepository.save(professional);
    }

    @Override
    public List<Professional> getListProfessionals() {
        return professionalRepository.findAll();
    }

    @Override
    public Professional findProfessionalById(Long searchedId) {
        return professionalRepository.findProfessionalBy(searchedId);
    }

    @Override
    public List<Professional> findProfessionalByName(String searchedName) {
        return professionalRepository.findAllByFirstName(searchedName);
    }

    @Override
    public void deleteProfessional(Long id) {
        Professional professional = findProfessionalById(id);
        professionalRepository.delete(professional);
    }

    @Override
    public void updateProfessional(Professional professional) {
        Professional professional1 = findProfessionalById(professional.getId());
        if (professional1 != null) {
            professional1.setFirstName(professional.getFirstName());
            professional1.setLastName(professional.getLastName());
            professional1.setEmail(professional.getEmail());
            professional1.setPhoneNumber(professional.getPhoneNumber());
            professional1.setAddress(professional.getAddress());
        }
    }
}
