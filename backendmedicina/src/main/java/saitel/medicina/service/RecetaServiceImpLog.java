package saitel.medicina.service;

import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import saitel.medicina.entity.Receta;
import saitel.medicina.repository.RecetaRepository;

@Service
public class RecetaServiceImpLog implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Receta guardar(Receta receta) {
    Integer idEmpleado = receta.getIdEmpleado();
    long count = recetaRepository.countByIdEmpleado(idEmpleado) + 1;
    DecimalFormat df = new DecimalFormat("00");
    receta.setNumeroReceta(df.format(count));
        try {
        
            String nombreDoctor = (String) em.createNativeQuery(
                "SELECT primer_nombre || ' ' || primer_apellido " +
                "FROM medicina.f_vta_empleado " +
                "WHERE id_rol = 45 AND estado = true " +
                "LIMIT 1")
                .getSingleResult();

            receta.setDoctorA("Dra. " + nombreDoctor);

            try {
                String diagnostico = (String) em.createNativeQuery(
                    "SELECT descripcion FROM medicina.tbl_diagnostico " +
                    "WHERE id_empleado = :id " +
                    "ORDER BY id_diagnostico DESC LIMIT 1")
                    .setParameter("id", idEmpleado)
                    .getSingleResult();

                receta.setDiagnostico(diagnostico);
            } catch (Exception e) {
                receta.setDiagnostico("Sin diagnóstico registrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("No se encontró empleado con la cédula proporcionada.");
        }

        receta.setFecha(new Date());
        return recetaRepository.save(receta);
    }
}