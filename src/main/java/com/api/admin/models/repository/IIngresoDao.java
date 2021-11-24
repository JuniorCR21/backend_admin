package com.api.admin.models.repository;

import java.util.List;

import com.api.admin.models.entity.Egreso;
import com.api.admin.models.entity.Ingreso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * IIngresoDao
 */
public interface IIngresoDao extends JpaRepository<Ingreso, Long> {
    @Query("SELECT e FROM Ingreso e order by fecha Desc")
	List<Ingreso> findAllOrderByFechaDesc();
}