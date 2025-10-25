package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.SignoVital;

@Repository
public interface SignoVitalRepository extends JpaRepository<SignoVital, Integer>{

}
