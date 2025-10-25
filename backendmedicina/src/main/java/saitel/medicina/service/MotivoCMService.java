package saitel.medicina.service;

import saitel.medicina.entity.MotivoCM;

public interface MotivoCMService {
    MotivoCM guardar(MotivoCM motivoCM);
    java.util.List<MotivoCM> findAll();
    java.util.Optional<MotivoCM> findById(Integer idMotivo);
    MotivoCM updateMotivoCM(Integer idMotivo, MotivoCM motivoCM);
    void deleteById(Integer idMotivo);
}
