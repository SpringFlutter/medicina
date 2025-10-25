package saitel.medicina.service;

import saitel.medicina.entity.Examen;

public interface ExamenService {
    Examen guardar(Examen examen);
    java.util.List<Examen> findAll();
    java.util.Optional<Examen> findById(Integer id);
    Examen updateExamen(Integer id, Examen examen);
    void deleteById(Integer id);
}
