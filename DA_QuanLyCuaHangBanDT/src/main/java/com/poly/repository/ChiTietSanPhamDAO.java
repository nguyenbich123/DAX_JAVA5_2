package com.poly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.ChiTietSP;
import com.poly.entity.SanPham;

public interface ChiTietSanPhamDAO extends JpaRepository<ChiTietSP,Integer>{
	@Query("SELECT o FROM ChiTietSP o WHERE o.maSP = ?1")
	Page<ChiTietSP> findBySP(SanPham maSP, Pageable pageable);

}
