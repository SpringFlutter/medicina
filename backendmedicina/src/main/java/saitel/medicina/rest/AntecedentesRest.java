package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saitel.medicina.entity.Antecedentes;
import saitel.medicina.service.AntecedentesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/antecedentes")
@CrossOrigin(origins = "*")
public class AntecedentesRest {

    @Autowired
    private AntecedentesService service;

    @PostMapping
    public Antecedentes guardarAntecedentes(@RequestBody Antecedentes antecedentes) {
        return service.guardarAntecedentes(antecedentes);
    }

    @GetMapping
    public List<Antecedentes> listarAntecedentes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Antecedentes> obtenerPorId(@PathVariable Long id) {
        Optional<Antecedentes> antecedente = service.findById(id);
        return antecedente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Antecedentes> actualizar(@PathVariable Long id, @RequestBody Antecedentes antecedentes) {
        Antecedentes actualizado = service.updateAntecedente(id, antecedentes);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
