package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.TTDH;
import com.poly.entity.TrangThaiTT;

public interface TTDH_DAO extends JpaRepository<TTDH,Integer>{

	Optional<TTDH> findByTrangThai(String trangThai);
}
