package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.SignoVital;
import saitel.medicina.service.SignoVitalService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signos-vitales")
@CrossOrigin(origins = "*")
public class SignoVitalRest {
    @Autowired
    private SignoVitalService signoVitalService;

    @PostMapping
    public SignoVital guardarSignoVital(@RequestBody SignoVital signoVital) {
        return signoVitalService.guardarSignoVital(signoVital);
    }

    @GetMapping
    public List<SignoVital> listarSignosVitales() {
        return signoVitalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignoVital> obtenerPorId(@PathVariable Integer id) {
        Optional<SignoVital> signo = signoVitalService.findById(id);
        return signo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignoVital> actualizar(@PathVariable Integer id, @RequestBody SignoVital signoVital) {
        SignoVital actualizado = signoVitalService.updateSignoVital(id, signoVital);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        signoVitalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
