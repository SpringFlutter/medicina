package saitel.medicina.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.AntecedentesFamiliar;
import saitel.medicina.service.AntFamiliarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/antecedentes-familiares")
public class AntFamiliarRest {
    private final AntFamiliarService service;

    public AntFamiliarRest(AntFamiliarService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AntecedentesFamiliar> guardar(@RequestBody AntecedentesFamiliar antecedente) {
        AntecedentesFamiliar guardado = service.guardarAntecedente(antecedente);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping
    public List<AntecedentesFamiliar> listarAntecedentes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AntecedentesFamiliar> obtenerPorId(@PathVariable Integer id) {
        Optional<AntecedentesFamiliar> antecedente = service.findById(id);
        return antecedente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentesFamiliar> actualizar(@PathVariable Integer id, @RequestBody AntecedentesFamiliar antecedente) {
        AntecedentesFamiliar actualizado = service.updateAntecedente(id, antecedente);
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
