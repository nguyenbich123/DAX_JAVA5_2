package com.poly.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Account;
import com.poly.entity.DonHang;
import java.util.List;


public interface DonHangDAO extends JpaRepository<DonHang,Integer>{

	// Truy vấn lấy ra danh sách đơn hàng của tài khoản đăng nhập
	Page<DonHang> findByMaKH(Account account, Pageable pageable);
    Page<DonHang> findByMaKHAndTtdhTrangThai(Account account, String trangThai, Pageable pageable);
    
    Optional<DonHang> findByMaDH(Integer maDH);
}
