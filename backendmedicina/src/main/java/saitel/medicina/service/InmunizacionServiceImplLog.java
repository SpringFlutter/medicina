package saitel.medicina.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saitel.medicina.entity.Inmunizacion;
import saitel.medicina.repository.InmunizacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InmunizacionServiceImplLog implements InmunizacionService {
    private static final Logger logger = LoggerFactory.getLogger(InmunizacionServiceImplLog.class);

    @Autowired
    private InmunizacionRepository inmunizacionRepository;

    @Override
    public Inmunizacion save(Inmunizacion inmunizacion) {
        logger.info("Guardando inmunización: {}", inmunizacion);
        return inmunizacionRepository.save(inmunizacion);
    }

    @Override
    public List<Inmunizacion> findAll() {
        logger.info("Obteniendo todas las inmunizaciones");
        return inmunizacionRepository.findAll();
    }

    @Override
    public Optional<Inmunizacion> findById(Integer id) {
        logger.info("Buscando inmunización por id: {}", id);
        return inmunizacionRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("Eliminando inmunización por id: {}", id);
        inmunizacionRepository.deleteById(id);
    }

    @Override
    public Inmunizacion updateInmunizacion(Integer id, Inmunizacion inmunizacion) {
        return inmunizacionRepository.findById(id)
            .map(existing -> {
                inmunizacion.setIdInmunizaciones(id);
                return inmunizacionRepository.save(inmunizacion);
            }).orElse(null);
    }
}
