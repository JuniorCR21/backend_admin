package com.api.admin.services.impl;

import com.api.admin.models.entity.Empleado;
import com.api.admin.models.repository.IEmpleadoDao;
import com.api.admin.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoDao _empleadoDao;

    @Override
    public List<Empleado> findAll() {
        return _empleadoDao.findAllByEstaActivoIsTrueOrderByNombreAsc();
    }

    @Override
    public Empleado findByDni(String dni) {
        return _empleadoDao.findByDniAndEstaActivoIsTrue(dni).orElse(null);
    }

    @Override
    public Empleado save(Empleado empleado) {
        return _empleadoDao.save(empleado);
    }

    @Override
    public boolean delete(Long id) {
        if(_empleadoDao.findById(id).isPresent()){
            var empleado = _empleadoDao.findById(id).get();
            empleado.setEstaActivo(false);
            _empleadoDao.save(empleado);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Empleado empleado) {
        if(_empleadoDao.findByIdAndEstaActivoIsTrue(empleado.getId()).isPresent()){
            _empleadoDao.save(empleado);
            return true;
        }
        return false;
    }
}
