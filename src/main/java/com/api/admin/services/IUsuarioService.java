package com.api.admin.services;

import java.util.List;

import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;

public interface IUsuarioService {

	public Usuario save(Usuario entity);
	public Usuario findById(Long id);
	public List<Usuario> findAll();
	public Usuario edit();
	public void delete();
	public Usuario saveToken (AuthenticationRequest request, String token);
	public Usuario findByUsernameAndPassword(String username, String password);
	public void deleteToken (String username);
	public int updateUserById(String username, String token,  Long id);
}
