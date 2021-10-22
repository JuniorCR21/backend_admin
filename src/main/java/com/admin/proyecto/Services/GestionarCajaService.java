package com.admin.proyecto.Services;

import com.admin.proyecto.Models.Contratos.ICrudDao;
import com.admin.proyecto.Models.Entities.Caja;

import org.springframework.beans.factory.annotation.Autowired;

public class GestionarCajaService extends CrudService<Caja, Long> {

  @Autowired
  private ICrudDao<Caja, Long> cajaDao;

  @Override
  public ICrudDao<Caja, Long> getDao() {
    return cajaDao;
  }
  
}
