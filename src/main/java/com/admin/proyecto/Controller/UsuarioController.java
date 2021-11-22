package com.admin.proyecto.Controller;

import com.admin.proyecto.Models.Entities.Usuario;
import com.admin.proyecto.Services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends CrudController<Usuario, Long>{

  @Autowired
  private CrudService<Usuario, Long> usuarioService;

  @Override
  public CrudService<Usuario, Long> getService() {
    return usuarioService;
  }
  
}
