package com.poly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;
import com.poly.entity.GioHang;

public interface GioHangDAO extends JpaRepository<GioHang,Integer>{
    Optional<GioHang> findBymaKH(Account kh);

}
