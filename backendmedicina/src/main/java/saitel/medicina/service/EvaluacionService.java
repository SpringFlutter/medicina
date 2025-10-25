package saitel.medicina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saitel.medicina.entity.Evaluacion;
import saitel.medicina.repository.EvaluacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }

    public Optional<Evaluacion> findById(Long id) {
        return evaluacionRepository.findById(id);
    }

    public Evaluacion save(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public void deleteById(Long id) {
        evaluacionRepository.deleteById(id);
    }

    public List<Evaluacion> findByTipoEvaluacion(String tipoEvaluacion) {
        return evaluacionRepository.findByTipoEvaluacion(tipoEvaluacion);
    }

    public List<Evaluacion> findByIdEmpleado(Long idEmpleado) {
        return evaluacionRepository.findByIdEmpleado(idEmpleado);
    }
}
