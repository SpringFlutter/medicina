package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

import saitel.medicina.entity.Examen;
import saitel.medicina.service.ExamenService;

@RestController
@RequestMapping("/api/examenes")
@CrossOrigin(origins = "*")
public class ExamenRest {
    @Autowired
    private ExamenService examenService;

    @PostMapping
    public Examen guardar(@RequestBody Examen examen) {
        return examenService.guardar(examen);
    }

    @GetMapping
    public java.util.List<Examen> listarExamenes() {
        return examenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> obtenerPorId(@PathVariable Integer id) {
        java.util.Optional<Examen> examen = examenService.findById(id);
        return examen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> actualizar(@PathVariable Integer id, @RequestBody Examen examen) {
        Examen actualizada = examenService.updateExamen(id, examen);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        examenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
