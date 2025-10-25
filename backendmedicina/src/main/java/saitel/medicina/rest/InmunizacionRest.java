package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saitel.medicina.entity.Inmunizacion;
import saitel.medicina.service.InmunizacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inmunizaciones")
public class InmunizacionRest {
    @Autowired
    private InmunizacionService inmunizacionService;

    @PostMapping
    public ResponseEntity<Inmunizacion> create(@RequestBody Inmunizacion inmunizacion) {
        Inmunizacion saved = inmunizacionService.save(inmunizacion);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Inmunizacion>> getAll() {
        return ResponseEntity.ok(inmunizacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmunizacion> getById(@PathVariable Integer id) {
        Optional<Inmunizacion> inmunizacion = inmunizacionService.findById(id);
        return inmunizacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmunizacion> update(@PathVariable Integer id, @RequestBody Inmunizacion inmunizacion) {
        Inmunizacion updated = inmunizacionService.updateInmunizacion(id, inmunizacion);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        inmunizacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
