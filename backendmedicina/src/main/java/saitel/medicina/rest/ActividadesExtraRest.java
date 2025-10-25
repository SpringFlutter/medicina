package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.ActividadesExtraLaborales;
import saitel.medicina.service.ActividadesExtraService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividades-extra")
@CrossOrigin(origins = "*")
public class ActividadesExtraRest {
    @Autowired
    private ActividadesExtraService service;

    @PostMapping
    public ActividadesExtraLaborales guardarActividad(@RequestBody ActividadesExtraLaborales actividadesExtraLaborales) {
        return service.guardarActividad(actividadesExtraLaborales);
    }

    @GetMapping
    public List<ActividadesExtraLaborales> listarActividades() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadesExtraLaborales> obtenerPorId(@PathVariable Integer id) {
        Optional<ActividadesExtraLaborales> actividad = service.findById(id);
        return actividad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadesExtraLaborales> actualizar(@PathVariable Integer id, @RequestBody ActividadesExtraLaborales actividadesExtraLaborales) {
        ActividadesExtraLaborales actualizada = service.updateActividad(id, actividadesExtraLaborales);
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
