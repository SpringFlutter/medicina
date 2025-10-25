package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer>{

}
