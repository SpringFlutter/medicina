package saitel.medicina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import saitel.medicina.entity.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByIdEmpleado(Long idEmpleado);
    }
