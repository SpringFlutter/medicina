package saitel.medicina.service;

import saitel.medicina.entity.Antecedentes;

import java.util.List;
import java.util.Optional;

public interface AntecedentesService {
    Antecedentes guardarAntecedentes(Antecedentes antecedentes);
    List<Antecedentes> findAll();
    Optional<Antecedentes> findById(Long id);
    Antecedentes updateAntecedente(Long id, Antecedentes antecedentes);
    void deleteById(Long id);
}
