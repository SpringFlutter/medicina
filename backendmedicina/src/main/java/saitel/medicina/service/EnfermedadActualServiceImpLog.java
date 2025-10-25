package saitel.medicina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.EnfermedadActual;
import saitel.medicina.repository.EnfermedadActualRepository;

@Service
public class EnfermedadActualServiceImpLog implements EnfermedadActualService{
@Autowired
    private EnfermedadActualRepository enfermedadActualRepository;

    @Override
    public EnfermedadActual guardar(EnfermedadActual enfermedadActual) {
        return enfermedadActualRepository.save(enfermedadActual);
    }

    @Override
    public java.util.List<EnfermedadActual> findAll() {
        return enfermedadActualRepository.findAll();
    }

    @Override
    public java.util.Optional<EnfermedadActual> findById(Integer id) {
        return enfermedadActualRepository.findById(id);
    }

    @Override
    public EnfermedadActual updateEnfermedadActual(Integer id, EnfermedadActual enfermedadActual) {
        return enfermedadActualRepository.findById(id)
            .map(existing -> {
                enfermedadActual.setIdEnfermedadActual(id);
                return enfermedadActualRepository.save(enfermedadActual);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        enfermedadActualRepository.deleteById(id);
    }
}
