package saitel.medicina.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import saitel.medicina.entity.Empleado;
import saitel.medicina.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpLog implements EmpleadoService{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado saveEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado getEmpleado(Long idEmpleado){
        Optional<Empleado> empleado = empleadoRepository.findByIdEmpleado(idEmpleado);
        if(empleado.isPresent()){
            return empleado.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado con id " + idEmpleado + " no encontrado");
        }
    }

    @Override
    public java.util.List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public java.util.Optional<Empleado> findById(Long idEmpleado) {
        return empleadoRepository.findById(idEmpleado);
    }

    @Override
    public Empleado updateEmpleado(Long idEmpleado, Empleado empleado) {
        return empleadoRepository.findById(idEmpleado)
            .map(existing -> {
                empleado.setIdEmpleado(idEmpleado);
                return empleadoRepository.save(empleado);
            }).orElse(null);
    }

    @Override
    public void deleteById(Long idEmpleado) {
        empleadoRepository.deleteById(idEmpleado);
    }
}
