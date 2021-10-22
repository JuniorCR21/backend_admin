package com.admin.proyecto.Controller;

import com.admin.proyecto.Models.Entities.Caja;
import com.admin.proyecto.Services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/caja")
public class CajaController extends CrudController<Caja, Long>{

  @Autowired
  private CrudService<Caja, Long> cajaService;

  @Override
  public CrudService<Caja, Long> getService() {
    return cajaService;
  }
  
}
