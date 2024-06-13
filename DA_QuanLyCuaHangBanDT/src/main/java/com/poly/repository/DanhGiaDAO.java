package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Account;
import com.poly.entity.DanhGia;
import com.poly.entity.SanPham;

public interface DanhGiaDAO extends JpaRepository<DanhGia, Integer> {
	
	@Query("SELECT COUNT(dg) > 0 FROM DanhGia dg WHERE dg.maKH = :maKH AND dg.maSP = :maSP")
    boolean daMuaVaDanhGiaSanPham(@Param("maKH") Account maKH, @Param("maSP") SanPham maSP);
}
