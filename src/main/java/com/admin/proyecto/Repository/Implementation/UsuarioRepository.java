package com.admin.proyecto.Repository.Implementation;

import com.admin.proyecto.Models.Entities.Usuario;
import com.admin.proyecto.Repository.InterfacesJPA.IUsuarioJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository extends CrudRepository<Usuario, Long>{

  @Autowired
  private IUsuarioJPA usuarioJpa;

  @Override
  public JpaRepository<Usuario, Long> getDao() {
    return usuarioJpa;
  }
    
}
