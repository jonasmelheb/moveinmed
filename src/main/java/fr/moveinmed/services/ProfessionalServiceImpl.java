package fr.moveinmed.services;

import fr.moveinmed.models.Professional;
import fr.moveinmed.repositories.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

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
        return professionalRepository.findProfessionalById(searchedId);
    }

    @Override
    public List<Professional> findAllByFirstNameContaining(String searchedName) {
        return professionalRepository.findAllByFirstNameIgnoreCaseContaining(searchedName);
    }

    @Override
    public void deleteProfessional(Long professionalId) {
        professionalRepository.findById(professionalId).map(professional -> {
            professionalRepository.delete(professional);
            return professional;
        });
    }

    @Override
    public void updateProfessional(Professional professionalUpdated, Long id) {
        professionalRepository.findById(id).map(professional -> {
            professional.setId(id);
            professional.setFirstName(professionalUpdated.getFirstName());
            professional.setLastName(professionalUpdated.getLastName());
            professional.setEmail(professionalUpdated.getEmail());
            professional.setPhoneNumber(professionalUpdated.getPhoneNumber());
            professional.setAddress(professionalUpdated.getAddress());
            professional.setProfession(professionalUpdated.getProfession());
            return professionalRepository.save(professional);
        });
    }
}
