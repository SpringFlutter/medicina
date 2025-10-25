package saitel.medicina.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import saitel.medicina.entity.MotivoCM;
import saitel.medicina.service.MotivoCMService;

@RestController
@RequestMapping("/api/motivo-consulta")
public class MotivoCMRest {
    private final MotivoCMService motivoCMService;
    public MotivoCMRest(MotivoCMService motivoCMService) {
        this.motivoCMService = motivoCMService;
    }

    @PostMapping
    public ResponseEntity<MotivoCM> guardarMotivoCM(@RequestBody MotivoCM motivoCM) {
        MotivoCM guardado = motivoCMService.guardar(motivoCM);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping
    public java.util.List<MotivoCM> listarMotivosCM() {
        return motivoCMService.findAll();
    }

    @GetMapping("/{idMotivo}")
    public ResponseEntity<MotivoCM> obtenerPorId(@PathVariable Integer idMotivo) {
        java.util.Optional<MotivoCM> motivoCM = motivoCMService.findById(idMotivo);
        return motivoCM.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{idMotivo}")
    public ResponseEntity<MotivoCM> actualizar(@PathVariable Integer idMotivo, @RequestBody MotivoCM motivoCM) {
        MotivoCM actualizada = motivoCMService.updateMotivoCM(idMotivo, motivoCM);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idMotivo}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer idMotivo) {
        motivoCMService.deleteById(idMotivo);
        return ResponseEntity.noContent().build();
    }
}
