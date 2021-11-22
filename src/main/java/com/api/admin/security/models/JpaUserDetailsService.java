package com.api.admin.security.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.admin.models.entity.Role;
import com.api.admin.models.entity.Usuario;
import com.api.admin.models.repository.IUsuarioDao;

@Service
public class JpaUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getActivo(), true, true,true,authorities);
	}
	
}
