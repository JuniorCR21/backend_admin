package com.api.admin.services;

import java.util.List;

import com.api.admin.models.entity.Egreso;

public interface IEgresoService {
    public List<Egreso> findAll();
    public List<Egreso> findAllOrderByFechaDesc();
}
