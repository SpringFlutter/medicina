package saitel.medicina.service;

import saitel.medicina.entity.Empleado;

public interface EmpleadoService {
    Empleado saveEmpleado(Empleado empleado);
    Empleado getEmpleado(Long idEmpleado);
    java.util.List<Empleado> findAll();
    java.util.Optional<Empleado> findById(Long idEmpleado);
    Empleado updateEmpleado(Long idEmpleado, Empleado empleado);
    void deleteById(Long idEmpleado);
}

