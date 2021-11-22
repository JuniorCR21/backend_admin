package com.api.admin.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.admin.controllers.IUsuarioController;
import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;
import com.api.admin.security.models.JpaUserDetailsService;
import com.api.admin.security.utils.JwtUtil;
import com.api.admin.services.IUsuarioServices;


@RestController
@RequestMapping("/api/v1/users")
public class UsuarioControllerImpl implements IUsuarioController{

	@Autowired
	private IUsuarioServices usuarioServices;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Override
	public ResponseEntity<List<Usuario>> listar() {
		return new ResponseEntity<>(usuarioServices.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Usuario> buscarPorId(Long id) {
		return new ResponseEntity<>(usuarioServices.findById(id), HttpStatus.OK);
	}

	@PostMapping("/")
	@Override
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario entity) {
		return new ResponseEntity<>(usuarioServices.save(entity), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> editar(Usuario entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostMapping("/login")
	@Override
	public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticationRequest authenticationRequest){
		
		if(usuarioServices.findByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword()) == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername().toString());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(usuarioServices.saveToken(authenticationRequest, jwt));
	}
	
	@GetMapping("/logout")
	@Override
	public ResponseEntity<?> logoutAuthentication (@RequestParam("username") String username) {
		usuarioServices.deleteToken(username);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
