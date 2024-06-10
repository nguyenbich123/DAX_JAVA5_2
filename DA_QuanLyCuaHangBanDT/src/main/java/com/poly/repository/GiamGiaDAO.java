package com.poly.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.DonHang;
import com.poly.entity.GiamGia;

public interface GiamGiaDAO extends JpaRepository<GiamGia,Integer>{

	Optional<GiamGia> findByMaGG(String maGG);
}
