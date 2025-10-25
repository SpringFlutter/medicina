package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.ActividadesExtraLaborales;
import saitel.medicina.repository.ActividadesExtraRepository;

@Service
public class ActividadesExtraServiceImpLog implements ActividadesExtraService{
    @Autowired
    private ActividadesExtraRepository actividadesExtraRepository;

    @Override
    public ActividadesExtraLaborales guardarActividad(ActividadesExtraLaborales actividadesExtraLaborales) {
        return actividadesExtraRepository.save(actividadesExtraLaborales);
    }

    @Override
    public List<ActividadesExtraLaborales> findAll() {
        return actividadesExtraRepository.findAll();
    }

    @Override
    public Optional<ActividadesExtraLaborales> findById(Integer id) {
        return actividadesExtraRepository.findById(id);
    }

    @Override
    public ActividadesExtraLaborales updateActividad(Integer id, ActividadesExtraLaborales actividadesExtraLaborales) {
        if (actividadesExtraRepository.existsById(id)) {
            actividadesExtraLaborales.setIdActividad(id);
            return actividadesExtraRepository.save(actividadesExtraLaborales);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        actividadesExtraRepository.deleteById(id);
    }
}
