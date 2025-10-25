package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.AntecedentesTrabajo;
import saitel.medicina.repository.AnTrabajoRepository;

@Service
public class AnTrabajoServiceImpLog implements AnTrabajoService{

    @Autowired
    private AnTrabajoRepository repository;

    @Override
    public AntecedentesTrabajo guardar(AntecedentesTrabajo antecedentesTrabajo) {
        return repository.save(antecedentesTrabajo);
    }

    @Override
    public List<AntecedentesTrabajo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AntecedentesTrabajo> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public AntecedentesTrabajo updateAntecedente(Integer id, AntecedentesTrabajo antecedentesTrabajo) {
        if (repository.existsById(id)) {
            antecedentesTrabajo.setId(id);
            return repository.save(antecedentesTrabajo);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
