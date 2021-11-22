package com.admin.proyecto.Models.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cajas")
public class Caja implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Float montoApertura;
  private Float montoCierre;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;
  private LocalTime horaApertura;
  private LocalTime horaCierre;

  @PrePersist
  public void iniciarCampos(){
    fecha = LocalDate.now();
    horaApertura = LocalTime.now();
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Float getMontoApertura() {
    return montoApertura;
  }
  public void setMontoApertura(Float montoApertura) {
    this.montoApertura = montoApertura;
  }
  public Float getMontoCierre() {
    return montoCierre;
  }
  public void setMontoCierre(Float montoCierre) {
    this.montoCierre = montoCierre;
  }
  public LocalDate getFecha() {
    return fecha;
  }
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }
  public LocalTime getHoraApertura() {
    return horaApertura;
  }
  public void setHoraApertura(LocalTime horaApertura) {
    this.horaApertura = horaApertura;
  }
  public LocalTime getHoraCierre() {
    return horaCierre;
  }
  public void setHoraCierre(LocalTime horaCierre) {
    this.horaCierre = horaCierre;
  }

}
