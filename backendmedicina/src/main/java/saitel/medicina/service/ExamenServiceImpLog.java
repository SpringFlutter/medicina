package saitel.medicina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.Examen;
import saitel.medicina.repository.ExamenRepository;

@Service
public class ExamenServiceImpLog implements ExamenService{
    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen guardar(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public java.util.List<Examen> findAll() {
        return examenRepository.findAll();
    }

    @Override
    public java.util.Optional<Examen> findById(Integer id) {
        return examenRepository.findById(id);
    }

    @Override
    public Examen updateExamen(Integer id, Examen examen) {
        return examenRepository.findById(id)
            .map(existing -> {
                examen.setIdExamen(id);
                return examenRepository.save(examen);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        examenRepository.deleteById(id);
    }
}
