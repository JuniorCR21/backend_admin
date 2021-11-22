package com.api.admin.services;

import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;

public interface IUsuarioServices extends ICrudServices<Usuario, Long>{

	public Usuario saveToken (AuthenticationRequest request, String token);
	public Usuario findByUsernameAndPassword(String username, String password);
	public void deleteToken (String username);
}
