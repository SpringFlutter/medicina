package saitel.medicina.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import saitel.medicina.entity.Formulario;
import saitel.medicina.service.FormularioService;




@RestController
@CrossOrigin
public class FormularioRest {
    @Autowired
    private FormularioService formularioService;

    @PostMapping("/ingresar/formulario")
    public ResponseEntity<Formulario> postFlormulario(@RequestBody Formulario formulario) {
        return new ResponseEntity<>(formularioService.saveFormulario(formulario), HttpStatus.CREATED);
    }

    @GetMapping("/obtener/formulario/{idFormulario}")
    public ResponseEntity<Formulario> getMethodName(@PathVariable Long idFormulario) {
        return new ResponseEntity<>(formularioService.getFormulario(idFormulario), HttpStatus.OK);
    }

    @GetMapping("/formularios")
    public ResponseEntity<java.util.List<Formulario>> listarFormularios() {
        return new ResponseEntity<>(formularioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/formulario/{id}")
    public ResponseEntity<Formulario> obtenerPorId(@PathVariable Long id) {
        java.util.Optional<Formulario> formulario = formularioService.findById(id);
        return formulario.map(f -> new ResponseEntity<>(f, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/formulario/{id}")
    public ResponseEntity<Formulario> actualizar(@PathVariable Long id, @RequestBody Formulario formulario) {
        Formulario actualizada = formularioService.updateFormulario(id, formulario);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/formulario/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        formularioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
