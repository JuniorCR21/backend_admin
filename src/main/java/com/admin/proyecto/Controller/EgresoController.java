package com.admin.proyecto.Controller;

import com.admin.proyecto.Models.Entities.Egreso;
import com.admin.proyecto.Services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/egreso")
public class EgresoController extends CrudController<Egreso, Long>{

  @Autowired
  private CrudService<Egreso, Long> egresoService;

  @Override
  public CrudService<Egreso, Long> getService() {
    return egresoService;
  }
  
}
  
