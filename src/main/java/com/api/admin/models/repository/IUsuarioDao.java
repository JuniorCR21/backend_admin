package com.api.admin.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.admin.models.entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String user);
	@Modifying
	@Query("UPDATE Usuario set username = ?1, token =?2 WHERE id = ?3")
	int updateUserById(String username, String token,  Long id);
}
