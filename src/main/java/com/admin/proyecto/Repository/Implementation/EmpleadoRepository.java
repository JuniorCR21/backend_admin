package com.admin.proyecto.Repository.Implementation;

import com.admin.proyecto.Models.Entities.Empleado;
import com.admin.proyecto.Repository.InterfacesJPA.IEmpleadoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoRepository extends CrudRepository<Empleado, Long>{
  
  @Autowired
  private IEmpleadoJPA empleadoJpa;

  @Override
  public JpaRepository<Empleado, Long> getDao() {
    return empleadoJpa;
  }
  
}
