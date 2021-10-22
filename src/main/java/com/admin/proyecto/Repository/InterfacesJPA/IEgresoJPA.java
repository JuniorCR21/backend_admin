package com.admin.proyecto.Repository.InterfacesJPA;

import com.admin.proyecto.Models.Entities.Egreso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEgresoJPA extends JpaRepository<Egreso, Long> {
  
}
