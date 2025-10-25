package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.RevisionOrganosSistemas;
import saitel.medicina.service.RevisionOrganosSistemasService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/revision-organos")
@CrossOrigin(origins = "*")
public class RevisionOrganosSistemasRest {
    @Autowired
    private RevisionOrganosSistemasService service;

    @PostMapping
    public RevisionOrganosSistemas guardar(@RequestBody RevisionOrganosSistemas revisionOrganosSistemas) {
        return service.guardarRevision(revisionOrganosSistemas);
    }

    @GetMapping
    public List<RevisionOrganosSistemas> listarRevisiones() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevisionOrganosSistemas> obtenerPorId(@PathVariable Integer id) {
        Optional<RevisionOrganosSistemas> revision = service.findById(id);
        return revision.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevisionOrganosSistemas> actualizar(@PathVariable Integer id, @RequestBody RevisionOrganosSistemas revisionOrganosSistemas) {
        RevisionOrganosSistemas actualizada = service.updateRevision(id, revisionOrganosSistemas);
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
