package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.AntecedentesTrabajo;
import saitel.medicina.service.AnTrabajoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/antecedentes-trabajo")
@CrossOrigin(origins = "*")
public class AnTrabajoRest {

    @Autowired
    private AnTrabajoService service;

    @PostMapping
    public AntecedentesTrabajo guardar(@RequestBody AntecedentesTrabajo antecedentesTrabajo) {
        return service.guardar(antecedentesTrabajo);
    }

    @GetMapping
    public List<AntecedentesTrabajo> listarAntecedentes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedentesTrabajo> obtenerPorId(@PathVariable Integer id) {
        Optional<AntecedentesTrabajo> antecedente = service.findById(id);
        return antecedente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentesTrabajo> actualizar(@PathVariable Integer id, @RequestBody AntecedentesTrabajo antecedentesTrabajo) {
        AntecedentesTrabajo actualizado = service.updateAntecedente(id, antecedentesTrabajo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
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
