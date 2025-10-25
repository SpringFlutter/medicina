package saitel.medicina.service;
import org.springframework.stereotype.Service;

import saitel.medicina.entity.NumeroHistoriaC;
import saitel.medicina.repository.NumeroHistoriaCRepository;

@Service
public class NumeroHistoriaCServiceImpLog implements NumeroHistoriaCService{
private final NumeroHistoriaCRepository repository;
public NumeroHistoriaCServiceImpLog(NumeroHistoriaCRepository repository){
    this.repository=repository;
}
@Override
public  NumeroHistoriaC guardar(NumeroHistoriaC numeroHistoriaC){
    return repository.save(numeroHistoriaC);
}
}
