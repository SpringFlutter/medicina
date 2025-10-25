package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.EnfermedadActual;

@Repository
public interface EnfermedadActualRepository extends JpaRepository<EnfermedadActual, Integer> {
}