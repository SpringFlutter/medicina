package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import saitel.medicina.entity.Empleado;
import saitel.medicina.service.EmpleadoService;



@RestController
@CrossOrigin
public class EmpleadoRest {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/ingresar/empleado")
    public ResponseEntity <Empleado> postEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<>(empleadoService.saveEmpleado(empleado), HttpStatus.CREATED);
    }

    @GetMapping("/obtener/empleado/{idEmpleado}")
    public ResponseEntity<Empleado> getMethodName(@PathVariable long idEmpleado) {
        return new ResponseEntity<>(empleadoService.getEmpleado(idEmpleado), HttpStatus.OK);
    }

    @GetMapping("/empleados")
    public ResponseEntity<java.util.List<Empleado>> listarEmpleados() {
        return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Long id) {
        java.util.Optional<Empleado> empleado = empleadoService.findById(id);
        return empleado.map(e -> new ResponseEntity<>(e, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado actualizada = empleadoService.updateEmpleado(id, empleado);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
