package saitel.medicina.service;

import saitel.medicina.entity.Inmunizacion;
import java.util.List;
import java.util.Optional;

public interface InmunizacionService {
    Inmunizacion save(Inmunizacion inmunizacion);
    List<Inmunizacion> findAll();
    Optional<Inmunizacion> findById(Integer id);
    Inmunizacion updateInmunizacion(Integer id, Inmunizacion inmunizacion);
    void deleteById(Integer id);
}
