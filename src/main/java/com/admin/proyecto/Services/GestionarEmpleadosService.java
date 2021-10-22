package com.admin.proyecto.Services;

import com.admin.proyecto.Models.Contratos.ICrudDao;
import com.admin.proyecto.Models.Entities.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionarEmpleadosService extends CrudService<Empleado, Long>{
  
  @Autowired
  private ICrudDao<Empleado, Long> empleadoDao;

  @Override
  public ICrudDao<Empleado, Long> getDao() {
    return empleadoDao;
  }

}
