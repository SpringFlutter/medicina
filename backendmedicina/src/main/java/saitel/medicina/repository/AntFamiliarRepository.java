package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.AntecedentesFamiliar;

@Repository
public interface AntFamiliarRepository extends JpaRepository <AntecedentesFamiliar, Integer>{

}
