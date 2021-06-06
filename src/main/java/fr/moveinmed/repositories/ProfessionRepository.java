package fr.moveinmed.repositories;

import fr.moveinmed.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    List<Profession> findProfessionByName(String name);

    Profession findProfessionById(Long id);
}
