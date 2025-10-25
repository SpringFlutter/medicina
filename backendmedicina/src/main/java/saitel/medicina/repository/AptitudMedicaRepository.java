package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.AptitudMedica;
@Repository
public interface AptitudMedicaRepository extends JpaRepository<AptitudMedica, Integer>{

}
