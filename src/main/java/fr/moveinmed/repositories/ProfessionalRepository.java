package fr.moveinmed.repositories;

import fr.moveinmed.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findAllByFirstNameContaining(String name);

    Professional findProfessionalById(Long id);
}
