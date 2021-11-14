package com.api.admin.models.repository;

import com.api.admin.models.entity.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEgresoDao extends JpaRepository<Egreso,Long> {
}
