package com.admin.proyecto.Repository.Implementation;

import com.admin.proyecto.Models.Entities.Ingreso;
import com.admin.proyecto.Repository.InterfacesJPA.IIngresoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class IngresoRepository extends CrudRepository<Ingreso,Long> {

  @Autowired
  private IIngresoJPA ingresoJpa;

  @Override
  public JpaRepository<Ingreso, Long> getDao() {
    return ingresoJpa;
  }
  
}
