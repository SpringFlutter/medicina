package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.AptitudMedica;
import saitel.medicina.repository.AptitudMedicaRepository;

@Service
public class AptitudMedicaServiceImpLog implements AptitudMedicaService{
    @Autowired
    private AptitudMedicaRepository aptitudMedicaRepository;

    @Override
    public AptitudMedica guardar(AptitudMedica aptitudMedica) {
        return aptitudMedicaRepository.save(aptitudMedica);
    }

    @Override
    public List<AptitudMedica> findAll() {
        return aptitudMedicaRepository.findAll();
    }

    @Override
    public Optional<AptitudMedica> findById(Integer id) {
        return aptitudMedicaRepository.findById(id);
    }

    @Override
    public AptitudMedica updateAptitud(Integer id, AptitudMedica aptitudMedica) {
        if (aptitudMedicaRepository.existsById(id)) {
            aptitudMedica.setIdAptitud(id);
            return aptitudMedicaRepository.save(aptitudMedica);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        aptitudMedicaRepository.deleteById(id);
    }
}
