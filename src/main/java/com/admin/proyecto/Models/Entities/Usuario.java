package com.admin.proyecto.Models.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String user;
  private String password;
  private Boolean activo;

  @OneToOne
  @JoinColumn(name="empleado_id",referencedColumnName = "id")
  private Empleado empleado;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  public Empleado getEmpleado() {
    return empleado;
  }
  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Boolean getActivo() {
    return activo;
  }
  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  
}
