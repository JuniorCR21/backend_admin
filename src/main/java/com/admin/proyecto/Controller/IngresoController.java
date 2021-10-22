package com.admin.proyecto.Controller;

import com.admin.proyecto.Models.Entities.Ingreso;
import com.admin.proyecto.Services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingreso")
public class IngresoController extends CrudController<Ingreso, Long>{

  @Autowired
  private CrudService<Ingreso, Long> ingresoService;

  @Override
  public CrudService<Ingreso, Long> getService() {
    return ingresoService;
  }
}
  
