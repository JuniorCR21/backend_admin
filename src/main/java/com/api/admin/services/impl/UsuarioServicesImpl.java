package com.api.admin.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.api.admin.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.admin.models.entity.Role;
import com.api.admin.models.entity.Usuario;
import com.api.admin.models.entity.dto.AuthenticationRequest;
import com.api.admin.models.repository.IRoleDao;
import com.api.admin.models.repository.IUsuarioDao;

@Service
public class UsuarioServicesImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioDao.findAll().isEmpty()? Collections.emptyList() : usuarioDao.findAll();
	}

	@Override
	public Usuario edit() {
		return null;
	}

	@Override
	public void delete() {

	}

	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Transactional
	public Usuario save(Usuario entity) {
		if(entity == null) {
			return new Usuario();
		}
		
		entity.setActivo(true);
		entity.setPassword(passEncoder.encode(entity.getPassword()));
		Usuario user = usuarioDao.save(entity);

		/* Añadiendo Roles*/
		List<Role> roles= new ArrayList<>();
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		role.setUsuario(user);
		roles.add(role);
		user.setRoles(roleDao.saveAll(roles));
		return usuarioDao.save(user);
	}

	@Transactional
	public Usuario edit(Usuario entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

	@Transactional
	public Usuario saveToken(AuthenticationRequest request, String token) {
		Usuario usuario = usuarioDao.findByUsername(request.getUsername());
		usuario.setToken(token);
		return usuarioDao.save(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario findByUsernameAndPassword(String username, String password) {
		Usuario user = usuarioDao.findByUsername(username);
		if(user == null || !passEncoder.matches(password, user.getPassword())) {
			return null;
		}
		return user;
	}

	@Transactional
	public void deleteToken(String username) {
		Usuario usuario = usuarioDao.findByUsername(username);
		usuario.setToken("");
		usuarioDao.save(usuario);
	}

	@Override
	public int updateUserById(String username, String token, Long id) {
		return usuarioDao.updateUserById(username, token, id);
	}

}
