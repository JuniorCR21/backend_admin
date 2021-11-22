package com.api.admin.services;

import java.time.LocalDate;
import java.util.List;

import com.api.admin.models.entity.Caja;
import com.api.admin.models.entity.Egreso;
import com.api.admin.models.entity.Ingreso;

public interface IGestionarCajaService {

  Caja save() throws Exception;

  List<Caja> findAll();

  List<Caja> findAllBetween(LocalDate startDate, LocalDate endDate);

  Caja findById(Long id);

  void cerrarCaja(Long id);

  Ingreso pagar(Ingreso ingreso, Long idCaja) throws Exception;
  Egreso retirar(float monto, Long idCaja, Long idEmpleado) throws Exception;
}
