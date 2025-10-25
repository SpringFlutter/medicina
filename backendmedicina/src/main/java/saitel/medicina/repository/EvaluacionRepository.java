
package saitel.medicina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saitel.medicina.entity.Evaluacion;
import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByTipoEvaluacion(String tipoEvaluacion);
    List<Evaluacion> findByIdEmpleado(Long idEmpleado);
}
