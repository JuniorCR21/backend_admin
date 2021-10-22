package com.admin.proyecto.Repository.InterfacesJPA;

import com.admin.proyecto.Models.Entities.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoJPA extends JpaRepository<Empleado, Long>{
  
}
