package saitel.medicina.service;
import saitel.medicina.entity.AntecedentesTrabajo;

import java.util.List;
import java.util.Optional;

public interface AnTrabajoService {
    AntecedentesTrabajo guardar(AntecedentesTrabajo antecedentesTrabajo);
    List<AntecedentesTrabajo> findAll();
    Optional<AntecedentesTrabajo> findById(Integer id);
    AntecedentesTrabajo updateAntecedente(Integer id, AntecedentesTrabajo antecedentesTrabajo);
    void deleteById(Integer id);
}
