package com.admin.proyecto.Repository.InterfacesJPA;

import com.admin.proyecto.Models.Entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioJPA extends JpaRepository<Usuario, Long> {
  
}
