package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saitel.medicina.entity.Evaluacion;
import saitel.medicina.service.EvaluacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionRest {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public List<Evaluacion> getAll() {
        return evaluacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> getById(@PathVariable Long id) {
        Optional<Evaluacion> evaluacion = evaluacionService.findById(id);
        return evaluacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Evaluacion create(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.save(evaluacion);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Evaluacion> getByTipo(@PathVariable String tipo) {
        return evaluacionService.findByTipoEvaluacion(tipo);
    }

    @GetMapping("/empleado/{idEmpleado}")
    public List<Evaluacion> getByEmpleado(@PathVariable Long idEmpleado) {
        return evaluacionService.findByIdEmpleado(idEmpleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> update(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        if (!evaluacionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        evaluacion.setIdEvaluacion(id);
        return ResponseEntity.ok(evaluacionService.save(evaluacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!evaluacionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        evaluacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
