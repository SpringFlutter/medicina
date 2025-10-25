package saitel.medicina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.SignoVital;
import saitel.medicina.repository.SignoVitalRepository;

@Service
public class SignoVitalServiceImpLog implements SignoVitalService {
    @Autowired
    private SignoVitalRepository signoVitalRepository;

    @Override
    public SignoVital guardarSignoVital(SignoVital signoVital) {
        return signoVitalRepository.save(signoVital);
    }

    @Override
    public List<SignoVital> findAll() {
        return signoVitalRepository.findAll();
    }

    @Override
    public Optional<SignoVital> findById(Integer id) {
        return signoVitalRepository.findById(id);
    }

    @Override
    public SignoVital updateSignoVital(Integer id, SignoVital signoVital) {
        if (signoVitalRepository.existsById(id)) {
            signoVital.setIdSignoVital(id);
            return signoVitalRepository.save(signoVital);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        signoVitalRepository.deleteById(id);
    }
}
