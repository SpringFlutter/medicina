package saitel.medicina.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import saitel.medicina.entity.ExamenFisico;
import saitel.medicina.service.ExamenFisicoService;


@RestController
@RequestMapping("/api/examen-fisico")
public class ExamenFisicoRest {
private final ExamenFisicoService service;

    public ExamenFisicoRest(ExamenFisicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExamenFisico> guardar(@RequestBody ExamenFisico examen) {
        ExamenFisico guardado = service.guardar(examen);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping
    public java.util.List<ExamenFisico> listarExamenesFisicos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenFisico> obtenerPorId(@PathVariable Integer id) {
        java.util.Optional<ExamenFisico> examen = service.findById(id);
        return examen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenFisico> actualizar(@PathVariable Integer id, @RequestBody ExamenFisico examen) {
        ExamenFisico actualizada = service.updateExamenFisico(id, examen);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
