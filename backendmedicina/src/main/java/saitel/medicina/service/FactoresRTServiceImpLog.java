package saitel.medicina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.FactoresRiesgoTrabajo;
import saitel.medicina.repository.FactoresRTRepository;

@Service
public class FactoresRTServiceImpLog implements FactoresRTService{
    @Autowired
    private FactoresRTRepository factoresRTRepository;

    @Override
    public FactoresRiesgoTrabajo guardar(FactoresRiesgoTrabajo factoresRiesgoTrabajo) {
        return factoresRTRepository.save(factoresRiesgoTrabajo);
    }

    @Override
    public java.util.List<FactoresRiesgoTrabajo> findAll() {
        return factoresRTRepository.findAll();
    }

    @Override
    public java.util.Optional<FactoresRiesgoTrabajo> findById(Integer id) {
        return factoresRTRepository.findById(id);
    }

    @Override
    public FactoresRiesgoTrabajo updateFactores(Integer id, FactoresRiesgoTrabajo factoresRiesgoTrabajo) {
        return factoresRTRepository.findById(id)
            .map(existing -> {
                factoresRiesgoTrabajo.setIdFactoresRiesgoTrabajo(id);
                return factoresRTRepository.save(factoresRiesgoTrabajo);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        factoresRTRepository.deleteById(id);
    }
}
