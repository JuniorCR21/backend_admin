package com.api.admin.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.api.admin.models.entity.Egreso;
import com.api.admin.models.repository.IEgresoDao;
import com.api.admin.services.IEgresoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EgresoServiceImpl implements IEgresoService {

    @Autowired
	private IEgresoDao egresoDao;

    @Override
	@Transactional(readOnly=true)
	public List<Egreso> findAll() {
		return (List<Egreso>) egresoDao.findAll();
	}
    
}
