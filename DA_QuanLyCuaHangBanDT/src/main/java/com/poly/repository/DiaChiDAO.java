package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;
import com.poly.entity.DiaChi;

public interface DiaChiDAO extends JpaRepository<DiaChi,Integer>{
//	List<DiaChi> findAllByTenDNLike(String keywords);
	
}
