package com.poly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham,Integer>{
	@Query("SELECT o FROM SanPham o WHERE o.tenSP LIKE ?1")
	Page<SanPham> findAllBykeyword(String keywords, Pageable pageable);
	
}
