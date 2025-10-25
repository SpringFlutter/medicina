package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.RecomendacionTratamiento;

@Repository
public interface RecomendacionTratamientoRepository extends JpaRepository<RecomendacionTratamiento, Integer>{

}
