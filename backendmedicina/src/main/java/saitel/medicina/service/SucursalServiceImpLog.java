package saitel.medicina.service;

import java.util.List;

import org.springframework.stereotype.Service;

import saitel.medicina.entity.Sucursal;
import saitel.medicina.repository.SucursalRepository;

@Service
public class SucursalServiceImpLog implements SucursalService {
private final SucursalRepository sucursalRepository;
public SucursalServiceImpLog (SucursalRepository sucursalRepository){
    this. sucursalRepository=sucursalRepository;
}
@Override
public List<Sucursal> ObtenerSucursalesOrdenadasPorId(){
    return sucursalRepository.findAllByEstadoTrueAndEliminadoFalseOrderByIdSucursalAsc();
}

}
