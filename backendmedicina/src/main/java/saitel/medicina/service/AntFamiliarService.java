package saitel.medicina.service;

import saitel.medicina.entity.AntecedentesFamiliar;

import java.util.List;
import java.util.Optional;

public interface AntFamiliarService {
    AntecedentesFamiliar guardarAntecedente(AntecedentesFamiliar antecedente);
    List<AntecedentesFamiliar> findAll();
    Optional<AntecedentesFamiliar> findById(Integer id);
    AntecedentesFamiliar updateAntecedente(Integer id, AntecedentesFamiliar antecedente);
    void deleteById(Integer id);
}
