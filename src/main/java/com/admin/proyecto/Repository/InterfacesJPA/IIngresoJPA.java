package com.admin.proyecto.Repository.InterfacesJPA;

import com.admin.proyecto.Models.Entities.Ingreso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngresoJPA extends JpaRepository<Ingreso, Long> {
  
}
