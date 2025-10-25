package saitel.medicina.service;

import saitel.medicina.entity.AptitudMedica;

import java.util.List;
import java.util.Optional;

public interface AptitudMedicaService {
    AptitudMedica guardar(AptitudMedica aptitudMedica);
    List<AptitudMedica> findAll();
    Optional<AptitudMedica> findById(Integer id);
    AptitudMedica updateAptitud(Integer id, AptitudMedica aptitudMedica);
    void deleteById(Integer id);
}
