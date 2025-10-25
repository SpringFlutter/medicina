package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.ExamenFisico;
@Repository
public interface ExamenFisicoRepository extends JpaRepository<ExamenFisico, Integer>{

}
