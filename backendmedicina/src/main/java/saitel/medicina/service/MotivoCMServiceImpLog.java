package saitel.medicina.service;

import org.springframework.stereotype.Service;

import saitel.medicina.entity.MotivoCM;
import saitel.medicina.repository.MotivoCMRepository;

@Service
public class MotivoCMServiceImpLog implements MotivoCMService{
private final MotivoCMRepository repository;
public MotivoCMServiceImpLog(MotivoCMRepository repository) {
        this.repository = repository;
}

    @Override
    public MotivoCM guardar(MotivoCM motivoCM) {
        return repository.save(motivoCM);
    }

    @Override
    public java.util.List<MotivoCM> findAll() {
        return repository.findAll();
    }

    @Override
    public java.util.Optional<MotivoCM> findById(Integer idMotivo) {
        return repository.findById(idMotivo);
    }

    @Override
    public MotivoCM updateMotivoCM(Integer idMotivo, MotivoCM motivoCM) {
        return repository.findById(idMotivo)
            .map(existing -> {
                motivoCM.setIdMotivo(idMotivo);
                return repository.save(motivoCM);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer idMotivo) {
        repository.deleteById(idMotivo);
    }
}
