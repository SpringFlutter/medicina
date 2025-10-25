package saitel.medicina.service;

import saitel.medicina.entity.FactoresRiesgoTrabajo;

public interface FactoresRTService {
    FactoresRiesgoTrabajo guardar(FactoresRiesgoTrabajo factoresRiesgoTrabajo);
    java.util.List<FactoresRiesgoTrabajo> findAll();
    java.util.Optional<FactoresRiesgoTrabajo> findById(Integer id);
    FactoresRiesgoTrabajo updateFactores(Integer id, FactoresRiesgoTrabajo factoresRiesgoTrabajo);
    void deleteById(Integer id);
}
