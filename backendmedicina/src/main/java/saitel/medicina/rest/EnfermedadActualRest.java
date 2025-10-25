package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import saitel.medicina.entity.EnfermedadActual;
import saitel.medicina.service.EnfermedadActualService;

@RestController
@RequestMapping("/api/enfermedad-actual")
public class EnfermedadActualRest {
    @Autowired
    private EnfermedadActualService enfermedadActualService;

    @PostMapping
    public EnfermedadActual guardar(@RequestBody EnfermedadActual enfermedadActual) {
        return enfermedadActualService.guardar(enfermedadActual);
    }

    @GetMapping
    public java.util.List<EnfermedadActual> listarEnfermedadesActuales() {
        return enfermedadActualService.findAll();
    }

    @GetMapping("/{id}")
    public org.springframework.http.ResponseEntity<EnfermedadActual> obtenerPorId(@org.springframework.web.bind.annotation.PathVariable Integer id) {
        java.util.Optional<EnfermedadActual> enfermedadActual = enfermedadActualService.findById(id);
        return enfermedadActual.map(org.springframework.http.ResponseEntity::ok).orElseGet(() -> org.springframework.http.ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity<EnfermedadActual> actualizar(@org.springframework.web.bind.annotation.PathVariable Integer id, @org.springframework.web.bind.annotation.RequestBody EnfermedadActual enfermedadActual) {
        EnfermedadActual actualizada = enfermedadActualService.updateEnfermedadActual(id, enfermedadActual);
        if (actualizada != null) {
            return org.springframework.http.ResponseEntity.ok(actualizada);
        } else {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Void> eliminar(@org.springframework.web.bind.annotation.PathVariable Integer id) {
        enfermedadActualService.deleteById(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }
}
