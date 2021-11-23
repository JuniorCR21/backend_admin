package com.api.admin.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "dni",unique=true)
  private String dni;
  private String nombre;
  private String apellido;
  private String telefono;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fechaNacimiento;
  private LocalDate fechaRegistro;
  private boolean estaActivo;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @PrePersist
  public void setDatos() {
    fechaRegistro = LocalDate.now();
    estaActivo = true;
  }
}
