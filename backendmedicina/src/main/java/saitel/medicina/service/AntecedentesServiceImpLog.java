package saitel.medicina.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.Antecedentes;
import saitel.medicina.repository.AntecedentesRepository;

@Service
public class AntecedentesServiceImpLog implements AntecedentesService{
    @Autowired
    private AntecedentesRepository antecedentesRepository;

    @Override
    public Antecedentes guardarAntecedentes(Antecedentes antecedentes) {
        antecedentes.setFechaRegistro(LocalDateTime.now());
        return antecedentesRepository.save(antecedentes);
    }

    @Override
    public List<Antecedentes> findAll() {
        return antecedentesRepository.findAll();
    }

    @Override
    public Optional<Antecedentes> findById(Long id) {
        return antecedentesRepository.findById(id);
    }

    @Override
    public Antecedentes updateAntecedente(Long id, Antecedentes antecedentes) {
        if (antecedentesRepository.existsById(id)) {
            antecedentes.setIdAntecedente(id);
            return antecedentesRepository.save(antecedentes);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        antecedentesRepository.deleteById(id);
    }
}
