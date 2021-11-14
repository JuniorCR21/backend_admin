package com.api.admin.models.repository;

import com.api.admin.models.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByDniAndEstaActivoIsTrue(String dni);
    Optional<Empleado> findByIdAndEstaActivoIsTrue(Long id);
    List<Empleado> findAllByEstaActivoIsTrueOrderByNombreAsc();
}

