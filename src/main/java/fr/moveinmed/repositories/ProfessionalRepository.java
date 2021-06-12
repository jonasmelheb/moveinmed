package fr.moveinmed.repositories;

import fr.moveinmed.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long>, JpaSpecificationExecutor<Professional> {
    List<Professional> findAllByFirstNameIgnoreCaseContaining(String name);

    Professional findProfessionalById(Long id);
}
