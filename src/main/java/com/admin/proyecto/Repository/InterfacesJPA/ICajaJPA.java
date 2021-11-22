package com.admin.proyecto.Repository.InterfacesJPA;

import com.admin.proyecto.Models.Entities.Caja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICajaJPA extends JpaRepository<Caja, Long>{
  
}
