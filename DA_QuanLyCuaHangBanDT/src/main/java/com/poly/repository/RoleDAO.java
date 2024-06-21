package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Role;
import java.util.List;


public interface RoleDAO extends JpaRepository<Role,Integer>{
	Optional<Role> findByIdrole(Integer idrole);
	
	Optional<Role> findByRoles(String roles);
}
