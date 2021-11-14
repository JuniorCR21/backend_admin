package com.api.admin.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.admin.models.entity.Role;

@Repository
public interface IRoleDao extends JpaRepository<Role, Long>{

}
