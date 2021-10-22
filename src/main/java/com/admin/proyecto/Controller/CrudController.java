package com.admin.proyecto.Controller;

import java.io.Serializable;
import java.util.List;

import com.admin.proyecto.Services.CrudService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudController<T, ID extends Serializable> {
  
  public abstract CrudService<T, ID> getService();

  // GET /entity
  @GetMapping
  public ResponseEntity<List<T>> Buscar() {
    var listaCiudadanos = getService().Buscar();
    return new ResponseEntity<>(listaCiudadanos, HttpStatus.OK);
  }

  // POST /entity
  @PostMapping
  public ResponseEntity<T> Guardar(@RequestBody T entity){
    var newEntity = getService().Guardar(entity);
    return new ResponseEntity<>(newEntity, HttpStatus.OK);
  }

  // GET /entity/{id}
  @GetMapping("{id}")
  public ResponseEntity<T> Buscar(@PathVariable ID id){
    var entity = getService().Buscar(id);
    return new ResponseEntity<>(entity, HttpStatus.OK);
  }

  // PUT /entity
  @PutMapping
  public ResponseEntity<?> Editar(@RequestBody T entity) {
    getService().Editar(entity);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // DELETE /entity/{id}
  @DeleteMapping("{id}")
  public ResponseEntity<?> Eliminar(@PathVariable ID id) {
    getService().Eliminar(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
