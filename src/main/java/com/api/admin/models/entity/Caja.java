package com.api.admin.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cajas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Caja implements Serializable {

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
  private boolean estaAbierta;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Ingreso> ingresos;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "caja")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Egreso> egresos;
  @PrePersist
  public void setCamposApertura() {
    fecha = LocalDate.now();
    horaApertura = LocalTime.now();
    estaAbierta = true;
    montoCierre = montoApertura;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public void agregarIngreso(Ingreso ingreso) {
    System.out.println("nombre: "+ ingreso.getNombre());
    montoCierre += ingreso.getMonto();
    ingresos.add(ingreso);
  }
  public boolean agregarEgreso(Egreso egreso){
    montoCierre -= egreso.getMonto();
    if(montoCierre>0){
      egresos.add(egreso);
      return true;
    }
    return false;
  }
}
