package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.PTTT;

public interface PTTT_DAO extends JpaRepository<PTTT,Integer>{

	Optional<PTTT> findByTenPT(String tenPT);
}
