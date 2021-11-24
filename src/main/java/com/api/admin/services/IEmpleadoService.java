package com.api.admin.services;

import com.api.admin.models.entity.Empleado;

import java.util.List;


public interface IEmpleadoService {
    List<Empleado> findAll();
    Empleado findByDni(String dni);
    Empleado save(Empleado empleado);
    boolean delete(Long id);
    boolean update(Empleado empleado);
    boolean activar(Long id);
}
