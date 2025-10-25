package saitel.medicina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.Diagnostico;
import saitel.medicina.repository.DiagnosticoRepository;

@Service
public class DiagnosticoServiceImpLog implements DiagnosticoService{
 @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public Diagnostico guardar(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    @Override
    public java.util.List<Diagnostico> findAll() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public java.util.Optional<Diagnostico> findById(Integer id) {
        return diagnosticoRepository.findById(id);
    }

    @Override
    public Diagnostico updateDiagnostico(Integer id, Diagnostico diagnostico) {
        return diagnosticoRepository.findById(id)
            .map(existing -> {
                diagnostico.setIdDiagnostico(id);
                return diagnosticoRepository.save(diagnostico);
            }).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        diagnosticoRepository.deleteById(id);
    }
}
