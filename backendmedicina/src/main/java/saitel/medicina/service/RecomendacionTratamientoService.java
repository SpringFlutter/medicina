package saitel.medicina.service;

import saitel.medicina.entity.RecomendacionTratamiento;

import java.util.List;
import java.util.Optional;

public interface RecomendacionTratamientoService {
    RecomendacionTratamiento guardar(RecomendacionTratamiento recomendacionTratamiento);
    List<RecomendacionTratamiento> findAll();
    Optional<RecomendacionTratamiento> findById(Integer id);
    RecomendacionTratamiento updateRecomendacion(Integer id, RecomendacionTratamiento recomendacionTratamiento);
    void deleteById(Integer id);
}
