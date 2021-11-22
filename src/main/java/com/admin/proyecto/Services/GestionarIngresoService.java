package com.admin.proyecto.Services;

import com.admin.proyecto.Models.Contratos.ICrudDao;
import com.admin.proyecto.Models.Entities.Ingreso;

import org.springframework.beans.factory.annotation.Autowired;

public class GestionarIngresoService extends CrudService<Ingreso, Long> {

  @Autowired
  private ICrudDao<Ingreso, Long> ingresoDao;

  @Override
  public ICrudDao<Ingreso, Long> getDao() {
    return ingresoDao;
  }
  
}
