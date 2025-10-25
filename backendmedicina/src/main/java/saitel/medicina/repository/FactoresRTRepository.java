package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.FactoresRiesgoTrabajo;

@Repository
public interface FactoresRTRepository extends JpaRepository<FactoresRiesgoTrabajo, Integer> {

}
