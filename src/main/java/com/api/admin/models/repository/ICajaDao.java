package com.api.admin.models.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.api.admin.models.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICajaDao extends JpaRepository<Caja, Long> {

  List<Caja> findAllByOrderByIdDesc();

  List<Caja> findByFechaBetween(LocalDate startDate, LocalDate endDate);

  Caja findTopByOrderByIdDesc();

  Optional<Caja> findTopByEstaAbiertaIsTrue();

  Optional<Caja> findByIdAndEstaAbiertaIsTrue(Long id);

}
