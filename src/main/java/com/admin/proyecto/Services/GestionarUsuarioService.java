package com.admin.proyecto.Services;

import com.admin.proyecto.Models.Contratos.ICrudDao;
import com.admin.proyecto.Models.Entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionarUsuarioService extends CrudService<Usuario, Long>{

  @Autowired
  private ICrudDao<Usuario, Long> usuarioDao;

  @Override
  public ICrudDao<Usuario, Long> getDao() {
    return usuarioDao;
  }

}