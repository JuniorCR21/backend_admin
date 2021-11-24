package com.api.admin.services.impl;

import java.util.List;

import com.api.admin.models.entity.Ingreso;
import com.api.admin.models.repository.IIngresoDao;
import com.api.admin.services.IIngresosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngresoServiceImpl implements IIngresosService{

    @Autowired
	private IIngresoDao ingresoDao;

    @Override
	@Transactional(readOnly=true)
	public List<Ingreso> findAll() {
		return (List<Ingreso>) ingresoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ingreso> findAllOrderByFechaDesc() {
		return ingresoDao.findAllOrderByFechaDesc();
	}
}
