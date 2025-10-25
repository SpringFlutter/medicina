package saitel.medicina.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import saitel.medicina.entity.DatosProfesional;
import saitel.medicina.repository.DatosProfesionalRepository;

@Service
public class DatosProfesionalServiceImpLog implements DatosProfesionalService {
 @Autowired
    private DatosProfesionalRepository repository;
 @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public DatosProfesional guardar(DatosProfesional datosProfesional) {
        String nombresApellidos;
        try {
            nombresApellidos = (String) em.createNativeQuery(
                "SELECT primer_nombre || ' ' || primer_apellido " +
                "FROM medicina.f_vta_empleado " +
                "WHERE id_rol = 45 AND estado = true " +
                "LIMIT 1")
                .getSingleResult();
            nombresApellidos = "Dra. " + nombresApellidos;
        } catch (NoResultException e) {
            nombresApellidos = "Dra. No Registrada";
        }
        datosProfesional.setNombresApellidos(nombresApellidos);
        datosProfesional.setFecha(LocalDate.now());
        datosProfesional.setHora(LocalTime.now());
        return repository.save(datosProfesional);
    }

    @Override
    public java.util.List<DatosProfesional> findAll() {
        return repository.findAll();
    }

    @Override
    public java.util.Optional<DatosProfesional> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public DatosProfesional updateDatosProfesional(Integer id, DatosProfesional datosProfesional) {
        return repository.findById(id)
            .map(existing -> {
                datosProfesional.setId(id);
                return repository.save(datosProfesional);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
