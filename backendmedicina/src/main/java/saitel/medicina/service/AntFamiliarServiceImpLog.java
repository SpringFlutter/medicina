package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import saitel.medicina.entity.AntecedentesFamiliar;
import saitel.medicina.repository.AntFamiliarRepository;

@Service
public class AntFamiliarServiceImpLog implements AntFamiliarService {
    private final AntFamiliarRepository repository;

    public AntFamiliarServiceImpLog (AntFamiliarRepository repository) {
        this.repository = repository;
    }

    @Override
    public AntecedentesFamiliar guardarAntecedente(AntecedentesFamiliar antecedentesFamiliar) {
        return repository.save(antecedentesFamiliar);
    }

    @Override
    public List<AntecedentesFamiliar> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AntecedentesFamiliar> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public AntecedentesFamiliar updateAntecedente(Integer id, AntecedentesFamiliar antecedente) {
        if (repository.existsById(id)) {
            antecedente.setIdAntecedenteFamiliar(id);
            return repository.save(antecedente);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
