package com.api.admin.models.repository;

import java.util.List;

import com.api.admin.models.entity.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEgresoDao extends JpaRepository<Egreso,Long> {

    @Query("SELECT e FROM Egreso e order by fecha Desc")
	List<Egreso> findAllOrderByFechaDesc();
}
