package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.RecomendacionTratamiento;
import saitel.medicina.repository.RecomendacionTratamientoRepository;

@Service
public class RecomendacionTratamientoServiceImpLog implements RecomendacionTratamientoService{
    @Autowired
    private RecomendacionTratamientoRepository recomendacionRepository;

    @Override
    public RecomendacionTratamiento guardar(RecomendacionTratamiento recomendacionTratamiento) {
        return recomendacionRepository.save(recomendacionTratamiento);
    }

    @Override
    public List<RecomendacionTratamiento> findAll() {
        return recomendacionRepository.findAll();
    }

    @Override
    public Optional<RecomendacionTratamiento> findById(Integer id) {
        return recomendacionRepository.findById(id);
    }

    @Override
    public RecomendacionTratamiento updateRecomendacion(Integer id, RecomendacionTratamiento recomendacionTratamiento) {
        if (recomendacionRepository.existsById(id)) {
            recomendacionTratamiento.setIdRecomendacion(id);
            return recomendacionRepository.save(recomendacionTratamiento);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        recomendacionRepository.deleteById(id);
    }
}
