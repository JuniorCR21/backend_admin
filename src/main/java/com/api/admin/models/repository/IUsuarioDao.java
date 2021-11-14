package com.api.admin.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.admin.models.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String user);
}
