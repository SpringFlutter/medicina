package saitel.medicina.service;

import saitel.medicina.entity.SignoVital;

import java.util.List;
import java.util.Optional;

public interface SignoVitalService {
    SignoVital guardarSignoVital(SignoVital signoVital);
    List<SignoVital> findAll();
    Optional<SignoVital> findById(Integer id);
    SignoVital updateSignoVital(Integer id, SignoVital signoVital);
    void deleteById(Integer id);
}
