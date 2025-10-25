package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.Antecedentes;

@Repository
public interface AntecedentesRepository extends JpaRepository<Antecedentes, Long>{

}
