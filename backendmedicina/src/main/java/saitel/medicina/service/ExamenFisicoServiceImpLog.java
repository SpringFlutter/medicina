package saitel.medicina.service;

import org.springframework.stereotype.Service;

import saitel.medicina.entity.ExamenFisico;
import saitel.medicina.repository.ExamenFisicoRepository;
@Service
public class ExamenFisicoServiceImpLog implements ExamenFisicoService{
private final ExamenFisicoRepository repository;

    public ExamenFisicoServiceImpLog(ExamenFisicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExamenFisico guardar(ExamenFisico examen) {
        examen.getIdEmpleado();
        return repository.save(examen);
    }

    @Override
    public java.util.List<ExamenFisico> findAll() {
        return repository.findAll();
    }

    @Override
    public java.util.Optional<ExamenFisico> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ExamenFisico updateExamenFisico(Integer id, ExamenFisico examen) {
        return repository.findById(id)
            .map(existing -> {
                examen.setIdExamenFisico(id);
                return repository.save(examen);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
