package saitel.medicina.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import saitel.medicina.entity.DatosProfesional;
import saitel.medicina.service.DatosProfesionalService;

@RestController
@RequestMapping("/api/datos-profesional")
public class DatosProfesionalRest {
    @Autowired
    private DatosProfesionalService datosProfesionalService;

    @PostMapping
    public DatosProfesional guardar(@RequestBody DatosProfesional datosProfesional) {
        return datosProfesionalService.guardar(datosProfesional);
    }

    @GetMapping
    public java.util.List<DatosProfesional> listarDatosProfesionales() {
        return datosProfesionalService.findAll();
    }

    @GetMapping("/{id}")
    public org.springframework.http.ResponseEntity<DatosProfesional> obtenerPorId(@org.springframework.web.bind.annotation.PathVariable Integer id) {
        java.util.Optional<DatosProfesional> datosProfesional = datosProfesionalService.findById(id);
        return datosProfesional.map(org.springframework.http.ResponseEntity::ok).orElseGet(() -> org.springframework.http.ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public org.springframework.http.ResponseEntity<DatosProfesional> actualizar(@org.springframework.web.bind.annotation.PathVariable Integer id, @org.springframework.web.bind.annotation.RequestBody DatosProfesional datosProfesional) {
        DatosProfesional actualizada = datosProfesionalService.updateDatosProfesional(id, datosProfesional);
        if (actualizada != null) {
            return org.springframework.http.ResponseEntity.ok(actualizada);
        } else {
            return org.springframework.http.ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Void> eliminar(@org.springframework.web.bind.annotation.PathVariable Integer id) {
        datosProfesionalService.deleteById(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }
}

