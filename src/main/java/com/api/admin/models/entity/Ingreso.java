package com.api.admin.models.entity;

import java.io.Serializable;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ingreso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingreso implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Float monto;
  private String dni;
  private String nombre;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime fecha;
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "caja_id", nullable = false)
  private Caja caja;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  @PrePersist
  public void setFecha() {
    fecha = LocalDateTime.now();
  }

  public boolean isMontoValido() {
    return (monto > 0);
  }
}
