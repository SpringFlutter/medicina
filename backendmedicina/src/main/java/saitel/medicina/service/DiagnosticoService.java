package saitel.medicina.service;

import saitel.medicina.entity.Diagnostico;

public interface DiagnosticoService {
    Diagnostico guardar(Diagnostico diagnostico);
    java.util.List<Diagnostico> findAll();
    java.util.Optional<Diagnostico> findById(Integer id);
    Diagnostico updateDiagnostico(Integer id, Diagnostico diagnostico);
    void deleteById(Integer id);
}
