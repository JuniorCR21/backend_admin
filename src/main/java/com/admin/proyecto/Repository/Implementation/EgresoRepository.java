package com.admin.proyecto.Repository.Implementation;

import com.admin.proyecto.Models.Entities.Egreso;
import com.admin.proyecto.Repository.InterfacesJPA.IEgresoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class EgresoRepository extends CrudRepository<Egreso, Long>{

  @Autowired
  private IEgresoJPA egresoJPA;

  @Override
  public JpaRepository<Egreso, Long> getDao() {
    return egresoJPA;
  }
  
}
