package com.api.admin.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICrudController<T,E> {

	@GetMapping("")
	public ResponseEntity<List<T>> listar();
	@GetMapping("/{id}")
	public ResponseEntity<T> buscarPorId(@PathVariable E id);
	@PostMapping("")
	public ResponseEntity<T> guardar(@RequestBody T entity);
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody T entity, @PathVariable E id);
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable E id);
}
