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

import saitel.medicina.entity.FactoresRiesgoTrabajo;
import saitel.medicina.service.FactoresRTService;

@RestController
@RequestMapping("/api/factores-riesgo")
@CrossOrigin(origins = "*")
public class FactoresRTRest {
    @Autowired
    private FactoresRTService factoresRTService;

    @PostMapping
    public FactoresRiesgoTrabajo crearFactoresRiesgo(@RequestBody FactoresRiesgoTrabajo factores) {
        return factoresRTService.guardar(factores);
    }

    @GetMapping
    public java.util.List<FactoresRiesgoTrabajo> listarFactores() {
        return factoresRTService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactoresRiesgoTrabajo> obtenerPorId(@PathVariable Integer id) {
        java.util.Optional<FactoresRiesgoTrabajo> factores = factoresRTService.findById(id);
        return factores.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactoresRiesgoTrabajo> actualizar(@PathVariable Integer id, @RequestBody FactoresRiesgoTrabajo factores) {
        FactoresRiesgoTrabajo actualizada = factoresRTService.updateFactores(id, factores);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        factoresRTService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}