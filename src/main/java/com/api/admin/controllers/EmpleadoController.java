package com.api.admin.controllers;

import com.api.admin.models.entity.Empleado;
import com.api.admin.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService _empleadoServices;

    @GetMapping
    public ResponseEntity<?> listar(){
        try {
            return new ResponseEntity<>(_empleadoServices.findAll(), HttpStatus.OK);
        }
        catch(Exception err){
            return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Empleado empleado){
        try {
            return new ResponseEntity<>(_empleadoServices.save(empleado), HttpStatus.CREATED);
        }
        catch(Exception err){
            return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Empleado empleado){
        try{
            if(_empleadoServices.update(empleado)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new Exception("No se pudo actualizar");
        }
        catch(Exception err){
            return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        try {
            if(_empleadoServices.delete(id)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            throw new Exception("No se pudo eliminar");
        }
        catch(Exception err){
            return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
