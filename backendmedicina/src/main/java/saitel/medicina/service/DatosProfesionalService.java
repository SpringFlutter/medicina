package saitel.medicina.service;

import saitel.medicina.entity.DatosProfesional;

public interface DatosProfesionalService {
    DatosProfesional guardar(DatosProfesional datosProfesional);
    java.util.List<DatosProfesional> findAll();
    java.util.Optional<DatosProfesional> findById(Integer id);
    DatosProfesional updateDatosProfesional(Integer id, DatosProfesional datosProfesional);
    void deleteById(Integer id);
}
