package com.api.admin.controllers;

import org.springframework.http.ResponseEntity;

import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;

public interface IUsuarioController extends ICrudController<Usuario, Long>{

	public ResponseEntity<?> createAuthenticationToken (AuthenticationRequest authenticationRequest);
	public ResponseEntity<?> logoutAuthentication (String username);
}
