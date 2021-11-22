package com.api.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;
import com.api.admin.security.models.JpaUserDetailsService;
import com.api.admin.security.utils.JwtUtil;
import com.api.admin.services.IUsuarioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/users")
public class UsuarioController{

	@Autowired
	private IUsuarioService usuarioServices;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	public ResponseEntity<List<Usuario>> listar() {
		return new ResponseEntity<>(usuarioServices.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<Usuario> buscarPorId(Long id) {
		return new ResponseEntity<>(usuarioServices.findById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario entity) {
		return new ResponseEntity<>(usuarioServices.save(entity), HttpStatus.CREATED);
	}

	public ResponseEntity<?> editar(Usuario entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticationRequest authenticationRequest){
		
		if(usuarioServices.findByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword()) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername().toString());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(usuarioServices.saveToken(authenticationRequest, jwt));
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logoutAuthentication (@RequestParam("username") String username) {
		usuarioServices.deleteToken(username);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
