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
@Table(name="ingresos")
public class Ingreso implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Float monto;
  private String dni;
  private String nombre;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;
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
  public Float getMonto() {
    return monto;
  }
  public void setMonto(Float monto) {
    this.monto = monto;
  }
  public String getDni() {
    return dni;
  }
  public void setDni(String dni) {
    this.dni = dni;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public LocalDate getFecha() {
    return fecha;
  }
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  
}
