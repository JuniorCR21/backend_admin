package com.api.admin.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ciudadanos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ciudadano implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String apellidos;
  private Long dni;
  private String email;
  private Long telefono;
  private String direccion;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}