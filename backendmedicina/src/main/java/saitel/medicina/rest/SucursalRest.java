package saitel.medicina.rest;

import org.springframework.web.bind.annotation.RestController;

import saitel.medicina.entity.Sucursal;
import saitel.medicina.service.SucursalService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/sucursales")
public class SucursalRest {
private final SucursalService sucursalService;
 public SucursalRest (SucursalService sucursalService){
    this.sucursalService=sucursalService;
 }
 @GetMapping()
 public List<Sucursal> listarSucursales() {
     return sucursalService.ObtenerSucursalesOrdenadasPorId();
 }
 
}
