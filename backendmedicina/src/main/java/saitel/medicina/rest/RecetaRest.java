package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.Receta;
import saitel.medicina.service.RecetaService;


@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*")
public class RecetaRest {
 @Autowired
    private RecetaService recetaService;

    @PostMapping
    public Receta guardar(@RequestBody Receta receta) {
        return recetaService.guardar(receta);
    }
}
