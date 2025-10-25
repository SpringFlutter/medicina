package saitel.medicina.service;

import saitel.medicina.entity.ExamenFisico;

public interface ExamenFisicoService {
    ExamenFisico guardar(ExamenFisico examen);
    java.util.List<ExamenFisico> findAll();
    java.util.Optional<ExamenFisico> findById(Integer id);
    ExamenFisico updateExamenFisico(Integer id, ExamenFisico examen);
    void deleteById(Integer id);
}   
