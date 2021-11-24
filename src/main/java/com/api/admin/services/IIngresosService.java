package com.api.admin.services;

import java.util.List;

import com.api.admin.models.entity.Ingreso;

public interface IIngresosService {
    public List<Ingreso> findAll();
    public List<Ingreso> findAllOrderByFechaDesc();
}
