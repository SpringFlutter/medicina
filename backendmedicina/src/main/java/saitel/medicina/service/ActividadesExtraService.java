package saitel.medicina.service;

import saitel.medicina.entity.ActividadesExtraLaborales;

import java.util.List;
import java.util.Optional;

public interface ActividadesExtraService {
    ActividadesExtraLaborales guardarActividad(ActividadesExtraLaborales actividadesExtraLaborales);
    List<ActividadesExtraLaborales> findAll();
    Optional<ActividadesExtraLaborales> findById(Integer id);
    ActividadesExtraLaborales updateActividad(Integer id, ActividadesExtraLaborales actividadesExtraLaborales);
    void deleteById(Integer id);
}
