package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.TrangThaiTT;

public interface TrangThaiTTDAO extends JpaRepository<TrangThaiTT, Integer> {

	Optional<TrangThaiTT> findByTrangThai(String tenTrangThai);

	
}
