package com.poly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.ChiTietSP;
import com.poly.entity.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham,Integer>{

	
}
