package saitel.medicina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import saitel.medicina.entity.Formulario;

public interface FormularioRepository extends JpaRepository <Formulario, Long>{
    Optional<Formulario> findByIdFormulario (Long idFormulario);

}
