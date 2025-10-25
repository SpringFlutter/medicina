package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.RecomendacionTratamiento;
import saitel.medicina.service.RecomendacionTratamientoService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recomendaciones")
@CrossOrigin(origins = "*")
public class RecomendacionTratamientoRest {
    @Autowired
    private RecomendacionTratamientoService recomendacionService;

    @PostMapping
    public RecomendacionTratamiento guardar(@RequestBody RecomendacionTratamiento recomendacion) {
        return recomendacionService.guardar(recomendacion);
    }

    @GetMapping
    public List<RecomendacionTratamiento> listarRecomendaciones() {
        return recomendacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecomendacionTratamiento> obtenerPorId(@PathVariable Integer id) {
        Optional<RecomendacionTratamiento> recomendacion = recomendacionService.findById(id);
        return recomendacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecomendacionTratamiento> actualizar(@PathVariable Integer id, @RequestBody RecomendacionTratamiento recomendacion) {
        RecomendacionTratamiento actualizada = recomendacionService.updateRecomendacion(id, recomendacion);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        recomendacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
