package saitel.medicina.service;

import saitel.medicina.entity.EnfermedadActual;

public interface EnfermedadActualService {
    EnfermedadActual guardar(EnfermedadActual enfermedadActual);
    java.util.List<EnfermedadActual> findAll();
    java.util.Optional<EnfermedadActual> findById(Integer id);
    EnfermedadActual updateEnfermedadActual(Integer id, EnfermedadActual enfermedadActual);
    void deleteById(Integer id);
}
