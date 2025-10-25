package saitel.medicina.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.DatosE;
import saitel.medicina.service.DatosEService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/datosE")
public class DatosERest {

@Autowired
private DatosEService datosEService;

@GetMapping
public ResponseEntity<List<DatosE>>obtenerTodos(){
    return ResponseEntity.ok(datosEService.obtenerTodos());
}
}
