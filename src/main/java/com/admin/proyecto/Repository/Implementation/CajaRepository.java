package com.admin.proyecto.Repository.Implementation;

import com.admin.proyecto.Models.Entities.Caja;
import com.admin.proyecto.Repository.InterfacesJPA.ICajaJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CajaRepository extends CrudRepository<Caja, Long>{

  @Autowired
  private ICajaJPA cajaJpa;

  @Override
  public JpaRepository<Caja, Long> getDao() {
    return cajaJpa;
  }
  
}
