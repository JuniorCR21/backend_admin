package com.api.admin.controllers;

import java.time.LocalDate;
import java.util.List;

import com.api.admin.models.entity.Caja;
import com.api.admin.models.entity.Egreso;
import com.api.admin.models.entity.Ingreso;
import com.api.admin.services.IGestionarCajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/caja")
public class GestionarCajaController {

  @Autowired
  private IGestionarCajaService _cajaService;

  @PostMapping
  public ResponseEntity<?> abrirCaja() {
    try {
      var caja = _cajaService.save();
      return new ResponseEntity<Caja>(caja, HttpStatus.CREATED);
    } catch (Exception err) {
      return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("{id}")
  public ResponseEntity<?> cerrarCaja(@PathVariable("id") Long id) {
    try {
      _cajaService.cerrarCaja(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("{id}")
  public ResponseEntity<?> buscarUno(@PathVariable Long id) {
    try {
      return new ResponseEntity<>(_cajaService.findById(id), HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping
  public ResponseEntity<List<Caja>> listar() {
    var cajasList = _cajaService.findAll();
    return new ResponseEntity<>(cajasList, HttpStatus.OK);
  }

  @GetMapping("/filtro")
  public ResponseEntity<List<Caja>> listarEntreFechas(String startDate, String endDate) {
    var cajasList = _cajaService.findAllBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));
    return new ResponseEntity<>(cajasList, HttpStatus.OK);
  }

  @PostMapping("/pagar/{idCaja}")
  public ResponseEntity<?> pagar(@RequestBody Ingreso ingreso, @PathVariable Long idCaja) {
    try {
      var pago = _cajaService.pagar(ingreso, idCaja);
      System.out.println("fecha: "+ ingreso.getFecha());
      return new ResponseEntity<>(pago, HttpStatus.CREATED);
    } catch (Exception err) {
      return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/retirar/{idEmpleado}/{idCaja}")
  public ResponseEntity<?> retirar(@RequestBody Egreso egreso,@PathVariable Long idCaja,@PathVariable Long idEmpleado) {
    try {
      var retiro = _cajaService.retirar(egreso, idCaja, idEmpleado);
      return new ResponseEntity<>(retiro, HttpStatus.CREATED);
    } catch (Exception err) {
      return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
