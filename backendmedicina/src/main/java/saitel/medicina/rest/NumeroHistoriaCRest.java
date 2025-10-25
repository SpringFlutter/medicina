package saitel.medicina.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.NumeroHistoriaC;
import saitel.medicina.service.NumeroHistoriaCService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/numeroHistoriaC")
public class NumeroHistoriaCRest {

private final NumeroHistoriaCService numeroHistoriaCService;
public NumeroHistoriaCRest(NumeroHistoriaCService numeroHistoriaCService){
    this.numeroHistoriaCService = numeroHistoriaCService;
}
@PostMapping    
public ResponseEntity<NumeroHistoriaC> guardarNumeroHistoriaC (@RequestBody NumeroHistoriaC numeroHistoriaC){
    NumeroHistoriaC guardado = numeroHistoriaCService.guardar(numeroHistoriaC);
    return ResponseEntity.ok(guardado);
}
}
