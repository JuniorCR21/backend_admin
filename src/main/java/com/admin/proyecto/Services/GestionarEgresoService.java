package com.admin.proyecto.Services;

import com.admin.proyecto.Models.Contratos.ICrudDao;
import com.admin.proyecto.Models.Entities.Egreso;

import org.springframework.beans.factory.annotation.Autowired;

public class GestionarEgresoService extends CrudService<Egreso, Long>{

  @Autowired
  private ICrudDao<Egreso, Long> egresoDao;

  @Override
  public ICrudDao<Egreso, Long> getDao() {
    return egresoDao;
  }
  
}
