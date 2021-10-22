package com.admin.proyecto.Models.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="egresos")
public class Egreso implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private float monto;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;

  @ManyToOne
  @JoinColumn(name="empleado_id",referencedColumnName = "id")
  private Empleado empleado;
  @ManyToOne
  @JoinColumn(name="caja_id",referencedColumnName = "id")
  private Caja caja;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public float getMonto() {
    return monto;
  }
  public void setMonto(float monto) {
    this.monto = monto;
  }
  public Empleado getEmpleado() {
    return empleado;
  }
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }
  public LocalDate getFecha() {
    return fecha;
  }
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  

}
