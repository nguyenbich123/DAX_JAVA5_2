package com.poly.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.ChiTietSP;
import com.poly.entity.SanPham;

public interface ChiTietSanPhamDAO extends JpaRepository<ChiTietSP,Integer>{
	@Query("SELECT o FROM ChiTietSP o WHERE o.maSP = ?1")
	Page<ChiTietSP> findBySP(SanPham maSP, Pageable pageable);
	
	@Query("SELECT c FROM ChiTietSP c WHERE " +
	           "(:min IS NULL OR c.gia >= :min) AND " +
	           "(:max IS NULL OR c.gia <= :max) AND " +
	           "(:keywords IS NULL OR c.maSP.tenSP LIKE %:keywords%)")
	    Page<ChiTietSP> findByCriteria(@Param("min") Double min, @Param("max") Double max, 
	                                   @Param("keywords") String keywords, Pageable pageable);

	@Query("SELECT o FROM ChiTietSP o WHERE o.maSP.tenSP LIKE ?1")
	Page<ChiTietSP> findByKeywords(String keywords, Pageable pageable);
	
}
