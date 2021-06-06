package fr.moveinmed.services;

import fr.moveinmed.models.Professional;
import fr.moveinmed.repositories.ProfessionRepository;
import fr.moveinmed.repositories.ProfessionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionRepository professionRepository;

    public ProfessionalServiceImpl(ProfessionalRepository professionalRepository, ProfessionRepository professionRepository) {
        this.professionalRepository = professionalRepository;
        this.professionRepository = professionRepository;
    }

    @Override
    public void addProfessional(Long professionId, Professional professional) {
        professionRepository.findById(professionId).map(profession -> {
            professional.setProfession(profession);
            return professionalRepository.save(professional);
        });
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
    public List<Professional> findProfessionalByName(String searchedName) {
        return professionalRepository.findAllByFirstName(searchedName);
    }

    @Override
    public void deleteProfessional(Long professionalId) {
        professionalRepository.findById(professionalId).map(professional -> {
            professionalRepository.delete(professional);
            return professional;
        });
    }

    @Override
    public void updateProfessional(Professional professionalUpdated) {
        professionalRepository.findById(professionalUpdated.getId()).map(professional -> {
            professional.setFirstName(professionalUpdated.getFirstName());
            professional.setLastName(professionalUpdated.getLastName());
            professional.setEmail(professionalUpdated.getEmail());
            professional.setPhoneNumber(professionalUpdated.getPhoneNumber());
            professional.setAddress(professionalUpdated.getAddress());
            return professionalRepository.save(professional);
        });
    }
}
