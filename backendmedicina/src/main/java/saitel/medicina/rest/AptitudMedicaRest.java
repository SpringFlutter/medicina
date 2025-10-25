package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.AptitudMedica;
import saitel.medicina.service.AptitudMedicaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aptitud-medica")
@CrossOrigin(origins = "*")
public class AptitudMedicaRest {
    @Autowired
    private AptitudMedicaService aptitudMedicaService;

    @PostMapping
    public AptitudMedica guardar(@RequestBody AptitudMedica aptitudMedica) {
        return aptitudMedicaService.guardar(aptitudMedica);
    }

    @GetMapping
    public List<AptitudMedica> listarAptitudes() {
        return aptitudMedicaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AptitudMedica> obtenerPorId(@PathVariable Integer id) {
        Optional<AptitudMedica> aptitud = aptitudMedicaService.findById(id);
        return aptitud.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AptitudMedica> actualizar(@PathVariable Integer id, @RequestBody AptitudMedica aptitudMedica) {
        AptitudMedica actualizada = aptitudMedicaService.updateAptitud(id, aptitudMedica);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        aptitudMedicaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
