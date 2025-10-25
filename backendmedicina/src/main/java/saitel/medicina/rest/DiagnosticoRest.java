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

import saitel.medicina.entity.Diagnostico;
import saitel.medicina.service.DiagnosticoService;

@RestController
@RequestMapping("/api/diagnosticos")
@CrossOrigin(origins = "*")
public class DiagnosticoRest {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @PostMapping
    public Diagnostico guardar(@RequestBody Diagnostico diagnostico) {
        return diagnosticoService.guardar(diagnostico);
    }

    @GetMapping
    public java.util.List<Diagnostico> listarDiagnosticos() {
        return diagnosticoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostico> obtenerPorId(@PathVariable Integer id) {
        java.util.Optional<Diagnostico> diagnostico = diagnosticoService.findById(id);
        return diagnostico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diagnostico> actualizar(@PathVariable Integer id, @RequestBody Diagnostico diagnostico) {
        Diagnostico actualizada = diagnosticoService.updateDiagnostico(id, diagnostico);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        diagnosticoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
