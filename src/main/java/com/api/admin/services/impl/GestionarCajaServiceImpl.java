package com.api.admin.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.api.admin.models.entity.Caja;
import com.api.admin.models.entity.Egreso;
import com.api.admin.models.entity.Ingreso;
import com.api.admin.models.repository.ICajaDao;
import com.api.admin.models.repository.IEgresoDao;
import com.api.admin.models.repository.IEmpleadoDao;
import com.api.admin.models.repository.IIngresoDao;
import com.api.admin.services.IGestionarCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionarCajaServiceImpl implements IGestionarCajaService {

  @Autowired
  private ICajaDao _cajaDao;
  @Autowired
  private IIngresoDao _ingresoDao;
  @Autowired
  private IEgresoDao _egresoDao;
  @Autowired
  private IEmpleadoDao _empleadoDao;

  @Override
  public Caja save() throws Exception {

    try {
      var hayCajaAbierta = _cajaDao.findTopByEstaAbiertaIsTrue().isPresent();
      if (hayCajaAbierta) {
        throw new Exception("Hay una caja abierta");
      } else {
        var ultimaCaja = _cajaDao.findTopByOrderByFechaDesc();
        var nuevaCaja = new Caja();

        if (ultimaCaja == null) {
          nuevaCaja.setMontoApertura(0f);
        } else {
          nuevaCaja.setMontoApertura(ultimaCaja.getMontoCierre());
        }
        return _cajaDao.save(nuevaCaja);
      }
    } catch (Exception err) {
      System.out.println(err.getMessage());
      throw err;
    }
  }

  @Override
  public List<Caja> findAll() {
    return _cajaDao.findAllByOrderByIdDesc();
  }

  @Override
  public List<Caja> findAllBetween(LocalDate startDate, LocalDate endDate) {
    return _cajaDao.findByFechaBetween(startDate, endDate);
  }

  @Override
  public void cerrarCaja(Long id) {
    if (_cajaDao.findById(id).isPresent()) {
      var caja = _cajaDao.findById(id).get();
      caja.setHoraCierre(LocalTime.now());
      caja.setEstaAbierta(false);
      var newCaja = _cajaDao.save(caja);
      System.out.println(newCaja);
    }
  }

  @Override
  public Caja findById(Long id) {
    return _cajaDao.findById(id).orElse(null);
  }

  @Override
  public Ingreso pagar(Ingreso ingreso, Long idCaja) throws Exception {
    try {
      if (_cajaDao.findByIdAndEstaAbiertaIsTrue(idCaja).isPresent()) {
        var caja = _cajaDao.findByIdAndEstaAbiertaIsTrue(idCaja).get();
        if (ingreso.isMontoValido()) {
          var nuevoIngreso = new Ingreso();
          System.out.println("nombre: "+ ingreso.getNombre());
          nuevoIngreso.setNombre(ingreso.getNombre());
          nuevoIngreso.setMonto(ingreso.getMonto());
          nuevoIngreso.setDni(ingreso.getDni());
          nuevoIngreso.setCaja(caja);
          nuevoIngreso = _ingresoDao.save(nuevoIngreso);
          caja.agregarIngreso(nuevoIngreso);
          _cajaDao.save(caja);
          return nuevoIngreso;
        } else {
          throw new Exception("Monto no es valido");
        }
      } else {
        throw new NullPointerException("Caja no existe o esta cerrada");
      }
    } catch (Exception err) {
      System.out.println(err.getMessage());
      throw err;
    }
  }

  @Override
  public Egreso retirar(Egreso egreso, Long idCaja, Long idEmpleado) throws Exception {
    try {
      if (_empleadoDao.findById(idEmpleado).isPresent()) {
        if (_cajaDao.findByIdAndEstaAbiertaIsTrue(idCaja).isPresent()) {
          //var egreso = new Egreso();
          //egreso.setMonto(monto);
          if (egreso.isMontoValido()) {
            var caja = _cajaDao.findByIdAndEstaAbiertaIsTrue(idCaja).get();
            if (caja.agregarEgreso(egreso)) {
              var empleado = _empleadoDao.findByIdAndEstaActivoIsTrue(idEmpleado).get();
              egreso.setEmpleado(empleado);
              egreso.setCaja(caja);
              egreso = _egresoDao.save(egreso);
              _cajaDao.save(caja);
              return egreso;
            }
            throw new Exception("Monto es mayor o igual al saldo disponible");
          }
          throw new Exception("Monto no es valido");
        }
        throw new NullPointerException("Caja no existe o esta cerrada");
      }
      throw new NullPointerException("Empleado no existe");
    } catch (Exception err) {
      System.out.println(err.getMessage());
      throw err;
    }
  }
}
