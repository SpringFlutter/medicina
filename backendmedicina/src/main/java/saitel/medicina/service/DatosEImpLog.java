package saitel.medicina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.DatosE;
import saitel.medicina.repository.DatosERepository;

@Service
public class DatosEImpLog implements DatosEService {
@Autowired
private DatosERepository datosERepository;
@Override
public List<DatosE> obtenerTodos(){
    return datosERepository.findAll();
}
}
