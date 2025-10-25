package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saitel.medicina.entity.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer>{
long countByIdEmpleado(Integer idEmpleado);
}
